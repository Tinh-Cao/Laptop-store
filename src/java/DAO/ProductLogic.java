/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProductDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author TInh
 */
public class ProductLogic {
     private ProductDAO dao;

    public ProductLogic() {
        dao = new ProductDAO();
    }

      public int findCurrentPage(HttpServletRequest request) {
        int currentPage = 0;
        if (request.getParameter("page") == null) {
            currentPage = 1;
        } else {
            try {
                currentPage = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
                currentPage = 1;
            }
        }
        return currentPage;
    }

    public int findTotalRecord(String keyword) {
        try {
            return dao.findTotalRecord(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int findTotalPage(int totalRecord) {
        int result = totalRecord / 9;
        if (totalRecord % 8 != 0) {
            result++;
        }
        return result;
    }

    public List<ProductDTO> findProductsByPage(int page, String keyword) {
        try {
            int offset = (page - 1) * 8;
            return dao.findProductsByPage(page, keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
