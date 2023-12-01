/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import untils.DBUtils;
import DTO.CategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class CategoryDAO extends DBUtils {

    public List<CategoryDTO> getAllCategory() throws SQLException {
        String sql = "SELECT * FROM Category";
        ArrayList<CategoryDTO> lc = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                CategoryDTO category = new CategoryDTO();
                category.setCategoryID(rs.getInt(1));
                category.setName(rs.getString(2));
                category.setDateCreated(rs.getString(3));
                category.setDateModified(rs.getString(4));
                category.setStatus(rs.getInt(5));
                lc.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return lc;
    }

    public List<CategoryDTO> displayCategoryinHome() throws SQLException {
        String sql = "SELECT * FROM Category WHERE Status = 1";
        ArrayList<CategoryDTO> lc = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                CategoryDTO category = new CategoryDTO();
                category.setCategoryID(rs.getInt(1));
                category.setName(rs.getString(2));
                category.setDateCreated(rs.getString(3));
                category.setDateModified(rs.getString(4));
                category.setStatus(rs.getInt(5));
                lc.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return lc;
    }

    public void addCategory(String name, String date, int Status) throws SQLException {
        String sql = "INSERT INTO [Category] (Name, DateCreated, Status) VALUES (?,?,?)";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, name.toUpperCase());
            ptm.setString(2, date);
            ptm.setInt(3, Status);
            ptm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public CategoryDTO getCategoryByColumnName(String columnName, String input) throws SQLException {
        String sql = "SELECT * FROM Category WHERE [" + columnName + "] = ?";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, input);
            rs = ptm.executeQuery();
            while (rs.next()) {
                CategoryDTO category = new CategoryDTO();
                category.setName(rs.getString(2));
                category.setStatus(rs.getInt(5));
                return category;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public void changeStatusCategoryByID(int status, int id) throws SQLException {
        String sql = "UPDATE Category SET Status = ? WHERE CategoryID  = ?";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, status);
            ptm.setInt(2, id);
            ptm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
