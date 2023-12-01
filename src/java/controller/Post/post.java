/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Post;

import DAO.PostDAO;
import DTO.AccountDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "post", urlPatterns = {"/addNews"})
public class post extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("AddNews.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int type = Integer.parseInt(request.getParameter("type"));
        String banner = request.getParameter("image");
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Chuyển LocalDate thành String
        String dateString = date.format(formatter);
        PostDAO pDAO = new PostDAO();
        HttpSession session = request.getSession();
        AccountDTO account = (AccountDTO) session.getAttribute("account");
//        response.getWriter().println(title);
//        response.getWriter().println(description);
//        response.getWriter().println(type);
//        response.getWriter().println(dateString);
//        response.getWriter().println(account.getAccountID());
//        response.getWriter().println(banner);
        int accountId = Integer.parseInt(account.getAccountID());
        pDAO.addPost(accountId, title, description, type, dateString, banner);
        request.getRequestDispatcher("AddNews.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
