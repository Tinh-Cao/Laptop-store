/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import untils.DBUtils;
import DTO.FeedbackDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tungl
 */
public class FeedbackDAO extends DBUtils {

    public List<FeedbackDTO> getFeedbackByProductID(int productID) {
        List<FeedbackDTO> feedbackList = new ArrayList<>();
        String sql = "SELECT FeedbackID, Title, Context, DateCreate, StarVoted, ProductID, AccountID FROM Feedback WHERE ProductID = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FeedbackDTO feedback = new FeedbackDTO();
                feedback.setFeedBackID(rs.getInt("FeedbackID"));
                feedback.setTilte(rs.getString("Title"));
                feedback.setContext(rs.getString("Context"));
                feedback.setDate(rs.getString("DateCreate"));
                feedback.setStart(rs.getInt("StarVoted"));
                feedback.setProductID(rs.getInt("ProductID"));
                feedback.setAccountID(rs.getInt("AccountID"));
                feedbackList.add(feedback);
            }
        } catch (Exception e) {
            // Handle any exceptions that occur
            e.printStackTrace(); // Print the exception for debugging purposes
        }
        return feedbackList;
    }

    public boolean checkFeedback(int status, int productID, int accountID) {
        String sql = "SELECT o.AccountID FROM OrderDetail od "
                + "JOIN Orders o ON od.OrderID = o.OrderID "
                + "WHERE o.Status = ? AND od.ProductID = ? AND o.AccountID = ?";
       Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, productID);
            ps.setInt(3, accountID);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Returns true if a feedback exists, false otherwise
        } catch (Exception e) {
            // Handle any exceptions that occur
            return false; // Return false in case of an exception
        }
    }

    public boolean insertFeedback(int accountID, String title, String context, String dateCreate, int starVoted, int productID) {
        String sql = "INSERT INTO Feedback (AccountID, Title, Context, DateCreate, StarVoted, ProductID) VALUES (?, ?, ?, ?, ?, ?)";
       Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);
            ps.setString(2, title);
            ps.setString(3, context);
            ps.setString(4, dateCreate);
            ps.setInt(5, starVoted);
            ps.setInt(6, productID);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Returns true if the insertion was successful
        } catch (Exception e) {
            // Handle any exceptions that occur
            e.printStackTrace(); // Print the exception for debugging purposes
            return false; // Return false in case of an exception
        }
    }

    public static void main(String[] args) {
        FeedbackDAO fDAO = new FeedbackDAO();
        AccountDAO aDAO = new AccountDAO();
//        fDAO.c
//        System.out.println(fDAO.checkFeedback(4,1,9));
        fDAO.insertFeedback(9, "", "hay", "", 5, 1);
        System.out.println(fDAO.checkFeedback(4, 1, 9));
    }
}
