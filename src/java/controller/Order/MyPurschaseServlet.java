/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Order;

import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import DTO.AccountDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msi
 */
@WebServlet(name = "MyPurschaseServlet", urlPatterns = {"/mypurchase"})
public class MyPurschaseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyPurschaseServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyPurschaseServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccountDTO account = (AccountDTO) session.getAttribute("account");
        OrderDAO odao = new OrderDAO();
        OrderDetailDAO odDAO = new OrderDetailDAO();
        ProductDAO pDAO = new ProductDAO();
        request.setAttribute("odDAO", odDAO);
        request.setAttribute("pDAO", pDAO);
        
        int accountId = Integer.parseInt(account.getAccountID()); // Convert account ID to int
        try {
            request.setAttribute("purchase", odao.myPurchase(accountId)); // Updated method call
        } catch (SQLException ex) {
            Logger.getLogger(MyPurschaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        request.getRequestDispatcher("MyPurchase.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
