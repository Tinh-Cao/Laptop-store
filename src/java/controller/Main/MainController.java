/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author msi
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)

@WebServlet(name = "MainController", urlPatterns = {"/maincontroller"})
public class MainController extends HttpServlet {

    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "login";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "logout";
    private static final String LOGIN_PAGE = "signin.jsp";
    private static final String SIGNUP_ACTION = "signup";
    private static final String SIGNUP_CONTROLLER = "signup";
    private static final String ADD_PRODUCT_ACTION = "addProduct";
    private static final String ADD_PRODUCT_CONTROLLER = "tableProduct";
    private static final String CHANGE_STATUS_PRODUCT_ACTION = "changeStatusProduct";
    private static final String CHANGE_STATUS_PRODUCT_CONTROLLER = "changeStatusProduct";
    private static final String VIEW_ORDER_DETAIL_ACTION = "detailOrder";
    private static final String VIEW_ORDER_DETAIL_CONTROLLER = "detailOrder";
    private static final String CHANGE_STATUS_ACCOUNT_ACTION = "changeStatusAccount";
    private static final String CHANGE_STATUS_ACCOUNT_CONTROLLER = "changeStatusAccount";
    private static final String ADD_VOUCHER_ACTION = "addVoucher";
    private static final String ADD_VOUCHER_CONTROLLER = "voucher";
    private static final String ADD_CATEGORY_ACTION = "addCate";
    private static final String ADD_CATEGORY_CONTROLLER = "tableCategory";
    private static final String Update_PRODUCT_CONTROLLER = "UpdateProduct";
     private static final String TOP1 = "top1";
      private static final String TOP_CONTROLLER = "Top1Controller";
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOGIN_PAGE;
            } else if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (SIGNUP_ACTION.equals(action)) {
                url = SIGNUP_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (ADD_PRODUCT_ACTION.equals(action)) {
                url = ADD_PRODUCT_CONTROLLER;
            } else if (CHANGE_STATUS_PRODUCT_ACTION.equals(action)) {
                url = CHANGE_STATUS_PRODUCT_CONTROLLER;
            } else if (VIEW_ORDER_DETAIL_ACTION.equals(action)) {
                url = VIEW_ORDER_DETAIL_CONTROLLER;
            } else if (CHANGE_STATUS_ACCOUNT_ACTION.equals(action)) {
                url = CHANGE_STATUS_ACCOUNT_CONTROLLER;
            } else if (ADD_VOUCHER_ACTION.equals(action)) {
                url = ADD_VOUCHER_CONTROLLER;
            } else if (ADD_CATEGORY_ACTION.equals(action)) {
                url = ADD_CATEGORY_CONTROLLER;
            } else if (Update_PRODUCT_CONTROLLER.equals(action)) {
                url = Update_PRODUCT_CONTROLLER;
            } else if (TOP1.equals(action)) {
                url = TOP_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
