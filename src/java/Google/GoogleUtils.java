/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

/**
 *
 * @author TInh
 */
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class GoogleUtils {

    public static String getToken(final String code) throws ClientProtocolException, IOException {
        String response = Request.Post(GoogleConfig.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form()
                        .add("client_id", GoogleConfig.GOOGLE_CLIENT_ID)
                        .add("client_secret", GoogleConfig.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", GoogleConfig.GOOGLE_REDIRECT_URI)
                        .add("code", code)
                        .add("grant_type", GoogleConfig.GOOGLE_GRANT_TYPE)
                        .build())
                .execute()
                .returnContent()
                .asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").getAsString();
        return accessToken;
    }

    public static GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = GoogleConfig.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link)
                .execute()
                .returnContent()
                .asString();

        GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
        System.out.println(googlePojo);
        return googlePojo;
    }
    
    public static String buildLoginUrl() throws UnsupportedEncodingException {
        String scope = "email profile";
        String redirectUri = URLEncoder.encode(GoogleConfig.GOOGLE_REDIRECT_URI, "UTF-8");

        String loginUrl = "https://accounts.google.com/o/oauth2/auth?"
                + "scope=" + scope
                + "&redirect_uri=" + redirectUri
                + "&response_type=code"
                + "&client_id=" + GoogleConfig.GOOGLE_CLIENT_ID
                + "&access_type=offline";

        return loginUrl;
    }
}
