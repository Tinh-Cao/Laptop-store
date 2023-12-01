/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Order;

import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msi
 */
@WebServlet(name = "DetailOrder", urlPatterns = {"/detailOrder"})
public class DetailOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDetailDAO odDAO = new OrderDetailDAO();
        ProductDAO pDAO = new ProductDAO();
        try {
            request.setAttribute("order", odDAO.getOrderDetailByID(Integer.parseInt(request.getParameter("id"))));
        } catch (SQLException ex) {
            Logger.getLogger(DetailOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("pDAO", pDAO);
        request.getRequestDispatcher("OrderDetail.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
