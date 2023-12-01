/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Product;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author TInh
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateProduct"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            ProductDAO pdao = new ProductDAO();
            request.setAttribute("p", pdao.getProductByID(Integer.parseInt(id)));

            ProductDAO productDAO = new ProductDAO();
            CategoryDAO cateDAO = new CategoryDAO();
            request.setAttribute("productID", id);
            request.setAttribute("cate", cateDAO.getAllCategory());
        } catch (SQLException ex) {
            Logger.getLogger(TableProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("productID"));
            String pname = request.getParameter("name");
            int cate = Integer.parseInt(request.getParameter("cate"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));
            String ram = request.getParameter("ram");
            String storage = request.getParameter("storage");
            String cpu = request.getParameter("cpu");
            String vga = request.getParameter("vga");
            String avatar;
            Part filePart = request.getPart("image");
            avatar = filePart.getSubmittedFileName();
            String savePath = "D:\\Semester_4\\PRJ301\\PRJ301_JSTL_WEB_Laptop\\web\\img";

            String filePath = savePath + File.separator + avatar;
            String ava = "img/" + avatar;
            // Lưu file ảnh vào thư mục images trên server
            filePart.write(filePath);
            ProductDAO pdao = new ProductDAO();
            pdao.updateProduct(id, cate, pname, quantity, price, ram, storage, cpu, vga, filePath);
            response.sendRedirect("tableProduct");
        } catch (SQLException ex) {
            Logger.getLogger(TableProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
