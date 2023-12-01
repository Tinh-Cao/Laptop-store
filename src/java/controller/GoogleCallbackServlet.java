package controller;

import DAO.AccountDAO;
import DTO.AccountDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import Google.GoogleConfig;

@WebServlet(name = "GoogleCallbackServlet", urlPatterns = {"/GoogleCallbackServlet"})
public class GoogleCallbackServlet extends HttpServlet {

    private static final String ERROR = "MyPurchase.jsp";
    private static final String SUCCESS = "home";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String code = request.getParameter("code");
            String token = getToken(code);
            AccountDTO account = getUserInfo(token);
            AccountDAO dao = new AccountDAO();
            if (!dao.checkDuplicate(account.getAccountID())) {
                dao.insert(account);
            }
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at GoogleCallbackController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private String getToken(String code) throws IOException {
        String url = GoogleConfig.GOOGLE_LINK_GET_TOKEN;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        String json = String.format("code=%s&client_id=%s&client_secret=%s&redirect_uri=%s&grant_type=%s",
                code,
                GoogleConfig.GOOGLE_CLIENT_ID,
                GoogleConfig.GOOGLE_CLIENT_SECRET,
                GoogleConfig.GOOGLE_REDIRECT_URI,
                GoogleConfig.GOOGLE_GRANT_TYPE);

        httpPost.setEntity(new StringEntity(json));
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");

        JSONObject jsonObject = new JSONObject(responseString);
        return jsonObject.getString("access_token");
    }

    private AccountDTO getUserInfo(String accessToken) throws IOException, JSONException {
        String url = GoogleConfig.GOOGLE_LINK_GET_USER_INFO + accessToken;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent();

        StringBuilder responseBuilder = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        char[] buffer = new char[1024];
        int bytesRead;
        while ((bytesRead = reader.read(buffer)) != -1) {
            responseBuilder.append(buffer, 0, bytesRead);
        }

        JSONObject jsonObject = new JSONObject(responseBuilder.toString());
        String AccountID = jsonObject.getString("id");
        String email = jsonObject.getString("email");
        String fullname = jsonObject.getString("name");
        return new AccountDTO(fullname,"","", fullname,"",email, "",2,1);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
