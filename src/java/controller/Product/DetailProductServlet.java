/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Product;

import DAO.AccountDAO;
import DAO.FeedbackDAO;
import DAO.ProductDAO;
import DTO.AccountDTO;
import DTO.ProductDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msi
 */
@WebServlet(name = "DetailProductServlet", urlPatterns = {"/detailProduct"})
public class DetailProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DetailProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DetailProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        int id = Integer.parseInt(id_raw);
        ProductDAO proDAO = new ProductDAO();
        ProductDTO pro = null;
        try {
            pro = proDAO.getProductByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(DetailProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("detail", pro);
        FeedbackDAO fDAO = new FeedbackDAO();
        HttpSession session = request.getSession();
        AccountDTO acc = (AccountDTO) session.getAttribute("account");
        
        if (acc != null) {
           UUID accountId = UUID.fromString(acc.getAccountID());
            //request.setAttribute("checkFeedback", fDAO.checkFeedback(4, pro.getProductID(), accountId));
        }
        AccountDAO aDAO = new AccountDAO();
        request.setAttribute("pro", pro);
        request.setAttribute("aDAO", aDAO);
//        fDAO.getFeedbackByProductID()
        
        request.setAttribute("feedback", fDAO.getFeedbackByProductID(pro.getProductID()));
//        response.getWriter().print(fDAO.checkFeedback(4, pro.getProductID(), acc.getAccountID()));
        request.getRequestDispatcher("detail.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id_raw = request.getParameter("id");
        int id_pro = Integer.parseInt(request.getParameter("id"));
        AccountDTO account = (AccountDTO) session.getAttribute("account");
        int id;
        try {

            id = Integer.parseInt(id_raw);

        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("detailProduct?id=" + id_pro);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
