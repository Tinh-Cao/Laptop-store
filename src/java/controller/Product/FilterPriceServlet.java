/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Product;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DTO.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import ProcessList.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author msi
 */
@WebServlet(name = "FilterPriceServlet", urlPatterns = {"/filterPrice"})
public class FilterPriceServlet extends HttpServlet {

    List<ProductDTO> list = new ArrayList<>();
    ProductDAO dao = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ProductDTO> list_raw = null;
        try {
            list_raw = dao.getAllProduct();
        } catch (SQLException ex) {
            Logger.getLogger(FilterPriceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("productsWithCategory", list_raw);
        request.getRequestDispatcher("shopListCate.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SortList sort = new SortList();
            String price_raw = request.getParameter("price");
            double price = 0;
            ProductDAO dao = new ProductDAO();
            String brand = request.getParameter("brand");
            String ram = request.getParameter("ram");
            String cpu = request.getParameter("cpu");
            String storage = request.getParameter("storage");
            String mode = request.getParameter("sortOrder");
            String VGA = request.getParameter("VGA");
            
            list = dao.filterProducts(brand, cpu, storage, ram, VGA);
            
            if (price_raw == null) {
                list = dao.filterProducts(brand, cpu, storage, ram, VGA);
            }
            if (mode == null) {
                
            } else if (mode.equalsIgnoreCase("1")) {
                list = sort.sortPrice(list, 1);
            } else {
                list = sort.sortPrice(list, 2);
            }
            request.setAttribute("productsWithCategory", list);
            CategoryDAO cdao = new CategoryDAO();
            request.setAttribute("cate", cdao.getAllCategory());
//        response.getWriter().print(price_raw);
//        response.getWriter().print(list_raw);
request.getRequestDispatcher("shopListCate.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(FilterPriceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
