/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import untils.DBUtils;
import DTO.*;
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
public class OrderDetailDAO extends DBUtils {

    public List<OrderDetail> getAllOrderDetail() throws SQLException {
        String sql = "SELECT OrderDetailID, ProductID, OrderID, Quantity, UnitPrice FROM OrderDetail";
        List<OrderDetail> orderDetails = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailID(rs.getInt("OrderDetailID"));
                orderDetail.setProduct_id(rs.getInt("ProductID"));
                orderDetail.setOrder_id(rs.getInt("OrderID"));
                orderDetail.setQuantity(rs.getInt("Quantity"));
                orderDetail.setOprice(rs.getDouble("UnitPrice"));
                orderDetails.add(orderDetail);
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
        return orderDetails;
    }

    public List<OrderDetail> getOrderDetailByID(int orderID) throws SQLException {
        String sql = "SELECT OrderDetailID, ProductID, OrderID, Quantity, UnitPrice FROM OrderDetail WHERE OrderID = ?";
        List<OrderDetail> t = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, orderID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailID(rs.getInt("OrderDetailID"));
                orderDetail.setProduct_id(rs.getInt("ProductID"));
                orderDetail.setOrder_id(rs.getInt("OrderID"));
                orderDetail.setQuantity(rs.getInt("Quantity"));
                orderDetail.setOprice(rs.getDouble("UnitPrice"));
                t.add(orderDetail);
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
        return t; // Return null if the order detail with the specified ID is not found
    }

    public static void main(String[] args) throws SQLException {
        OrderDetailDAO dao = new OrderDetailDAO();
        ProductDAO pDAO = new ProductDAO();
        System.out.println(dao.getOrderDetailByID(29).size());
    }
}
