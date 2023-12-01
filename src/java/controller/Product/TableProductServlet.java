/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Product;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msi
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)

@WebServlet(name = "TableProductServlet", urlPatterns = {"/tableProduct"})
public class TableProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductDAO productDAO = new ProductDAO();
            CategoryDAO cateDAO = new CategoryDAO();
            request.setAttribute("listProduct", productDAO.getAllProduct());
            request.setAttribute("cate", cateDAO.getAllCategory());
            request.getRequestDispatcher("TableProduct.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TableProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
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
            String savePath = "\"D:\\\\Semester_4\\PRJ301\\PRJ301_JSTL_WEB_Laptop\\web\\img";
            String filePath = savePath + File.separator + avatar;
            String ava = "img/" + avatar;
            // Lưu file ảnh vào thư mục images trên server
            filePart.write(filePath);
            ProductDAO pdao = new ProductDAO();
            pdao.addProduct(cate, pname, quantity, price, ram, storage, cpu, vga, 0, ava);
            
            response.sendRedirect("tableProduct");
        } catch (SQLException ex) {
            Logger.getLogger(TableProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
