/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import untils.DBUtils;
import DTO.AccountDTO;
import DTO.Cart;
import DTO.ItemDTO;
import DTO.OrderDTO;
import DTO.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class OrderDAO extends DBUtils {

    public void addOrder(AccountDTO a, Cart cart, String address, String voucher) throws SQLException {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            //add order
            String sql = "INSERT INTO ORDERS VALUES (?,?,?,?,?,?)";
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, a.getAccountID());
            ptm.setDouble(2, cart.getTotalMoney());
            ptm.setString(3, date);
            ptm.setString(4, address);
            ptm.setInt(5, 0);
            ptm.setString(6, voucher);
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

    public int getLastOrderID() throws SQLException {
        String sql = "select top 1 OrderID from Orders order by OrderID desc";
        int id = 0;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
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
        return id;
    }

    public void addOrderDetail(Cart cart, int oid) throws SQLException {
        String sql = "INSERT INTO OrderDetail VALUES (?,?,?,?,?)";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            for (ItemDTO i : cart.getItems()) {
                String sql_2 = "INSERT INTO OrderDetail VALUES (?,?,?,?)";
                ptm = conn.prepareStatement(sql_2);
                ptm.setInt(1, i.getProduct().getProductID());
                ptm.setInt(2, oid);
                ptm.setInt(3, i.getQuantity());
                ptm.setDouble(4, i.getProduct().getPrice() /*tru di tien discount*/);
                ptm.executeUpdate();
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

    }

    public void updateQuantity(Cart cart) throws SQLException {
        String sql_3 = "UPDATE Product SET QuantityAvailable = QuantityAvailable - ? WHERE ProductID = ?";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql_3);
            for (ItemDTO i : cart.getItems()) {
                ptm.setInt(1, i.getQuantity());
                ptm.setInt(2, i.getProduct().getProductID());
                ptm.executeUpdate();
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
    }

    public List<OrderDTO> listOrderInAdminHome(int number) throws SQLException {
        String sql = "SELECT TOP " + number + " od.OrderID,od.OrderDate, a.Fullname, od.TotalPrice, od.Status FROM Orders od\n"
                + "JOIN Account a \n"
                + "ON a.AccountID = od.AccountID ORDER BY od.OrderID DESC";
        List<OrderDTO> lo = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                OrderDTO ord = new OrderDTO();
                ord.setOrderID(rs.getInt(1));
                ord.setOrderDate(rs.getString(2));
                ord.setFullname(rs.getString(3));
                ord.setTotalPrice(rs.getDouble(4));
                ord.setStatus(rs.getInt(5));
                lo.add(ord);
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
        return lo;
    }

    public double todaySale() throws SQLException {
        // Lấy ngày hiện tại
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        double value = 0;
        // Tạo câu truy vấn SQL
        String query = "SELECT SUM(TotalPrice) AS TotalPriceSum FROM Orders WHERE OrderDate = '" + sqlDate + "' AND Status = 1";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(query);
            rs = ptm.executeQuery();
            while (rs.next()) {
                value = rs.getDouble(1);
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
        return value;
    }

    public List<OrderDTO> myPurchase(int id) throws SQLException {
        String sql = "SELECT o.OrderID, a.Fullname, o.TotalPrice, o.OrderDate,o.Address,o.Status FROM Orders o JOIN Account a ON a.AccountID = o.AccountID WHERE a.AccountID = ?";
        List<OrderDTO> lo = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, id);
            rs = ptm.executeQuery();
            while (rs.next()) {
                OrderDTO o = new OrderDTO();
                o.setOrderID(rs.getInt(1));
                o.setFullname(rs.getString(2));
                o.setTotalPrice(rs.getDouble(3));
                o.setOrderDate(rs.getString(4));
                o.setAddress(rs.getString(5));
                o.setStatus(rs.getInt(6));
                lo.add(o);
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
        return lo;
    }

    public List<OrderDetail> orderDetail(int oid) throws SQLException {
        String sql = "SELECT od.OrderDetailID, od.OrderID,p.Name,od.Quantity,od.UnitPrice FROM OrderDetail od\n"
                + "JOIN Product p \n"
                + "ON p.ProductID = od.ProductID WHERE od.OrderID = ?";
        List<OrderDetail> lod = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, oid);
            rs = ptm.executeQuery();
            while (rs.next()) {
                OrderDetail o = new OrderDetail();
                o.setOrderDetailID(rs.getInt(1));
                o.setOrder_id(rs.getInt(2));
                o.setPname(rs.getString(3));
                o.setQuantity(rs.getInt(4));
                o.setOprice(rs.getDouble(5));
                lod.add(o);
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
        return lod;
    }

    public void changeStatusOrder(int id, int status) throws SQLException {
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET [Status] = ?\n"
                + " WHERE OrderID = ?";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, status);
            ptm.setInt(2, id);
            ptm.executeUpdate();
        }catch (Exception e) {
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

    public static void main(String[] args) throws SQLException {
        OrderDAO dao = new OrderDAO();
        dao.changeStatusOrder(28, 0);
    }

}
