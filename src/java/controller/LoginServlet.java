/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.AccountDAO;
import DTO.AccountDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author msi
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        AccountDAO accountDAO = new AccountDAO();
        try {
            AccountDTO account = accountDAO.checkLogin(username, password);
            if (account == null) {
                String msg = "Username or Password is not correct!";
                request.setAttribute("mess", msg);
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            } else if (account.getRole() == 1) {
                session.setAttribute("account", account);
                response.sendRedirect("admin");
            } else if (account.getAccountStatus() == 0) {
                String msg = "Account was blocked by admin";
                request.setAttribute("mess", msg);
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            } else {
                session.setAttribute("account", account);
                response.sendRedirect("home");
            }
        } catch (Exception e) {

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
