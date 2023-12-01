/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {

    private String messUser, messPass, messRe_pass, messMail;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re-password");

        boolean Status = true;
        AccountDAO dao = new AccountDAO();
        try {
            if (dao.searchAccountByColumn("Username", username) != null) {
                String messUser = "Username exist!";
                request.setAttribute("messUser", messUser);
                Status = false;
            }
            if (dao.searchAccountByColumn("Email", mail) != null) {
                String messMail = "E-mail exist!";
                request.setAttribute("messMail", messMail);
                Status = false;
            }
            if (!password.equals(re_password)) {
                String messRe_pass = "Password and confirm password not same!";
                request.setAttribute("messRe_pass", messRe_pass);
                Status = false;
            } else if (Status) {
                // Tạo AccountID ngẫu nhiên
                String AccountID = UUID.randomUUID().toString();
                dao.register(AccountID, username, password, fullname, mail, 2);
                response.sendRedirect("login");
            }
            if (!Status) {
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

