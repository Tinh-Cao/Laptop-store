/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import untils.DBUtils;
import DTO.AccountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author msi
 */
public class AccountDAO {

    public AccountDTO checkLogin(String username, String password) throws SQLException {
        String sql = "SELECT * FROM Account WHERE Username = ? AND Password = ?";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setString(2, password);
            rs = ptm.executeQuery();
            while (rs.next()) {
                AccountDTO account = new AccountDTO();
                account.setAccountID(rs.getString(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setFullname(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setEmail(rs.getString(6));
                account.setAddress(rs.getString(7));
                account.setRole(rs.getInt(8));
                account.setAccountStatus(rs.getInt(9));
                return account;
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

    public void register(String AccountID,String username, String password, String Fullname, String Email, int role) throws SQLException {

        String sql = "INSERT INTO [dbo].[Account]\n"
            + "           ([AccountID]\n"
            + "           ,[Username]\n"
            + "           ,[Password]\n"
            + "           ,[Fullname]\n"
            + "           ,[Email]\n"
            + "           ,[Role], [Status])\n"
            + "     VALUES\n"
            + "           (?,?,?,?,?,?,?)";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, AccountID);
            ptm.setString(2, username);
            ptm.setString(3, password);
            ptm.setString(4, Fullname);
            ptm.setString(5, Email);
            ptm.setInt(6, role);
            ptm.setInt(7, 1);
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

private static final String TOP1 = "SELECT TOP (1)Username, FullName FROM Account";

public AccountDTO top1() throws SQLException {
        AccountDTO la = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(TOP1);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String Username = rs.getString("Username");
                    String FullName = rs.getString("FullName");
                    la = new AccountDTO("",Username,"", FullName,"","","",1,1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            };
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return la;
    }

    public boolean checkDuplicate(String AccountID) throws SQLException {
        String sql = "SELECT [Fullname] FROM [dbo].[Account] WHERE AccountID = ?";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, AccountID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
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
        return check;
    }

    public boolean insert(AccountDTO account) throws SQLException {
        String sql = "INSERT INTO Account(AccountID,Fullname,Email,Phone,Role,Password) VALUES(?,?,?,?,?,?)";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, account.getAccountID());
                ptm.setString(2, account.getFullname());
                ptm.setString(3, account.getEmail());
                ptm.setString(4, account.getPhone());
                ptm.setInt(5, account.getRole());
                ptm.setString(6, account.getPassword());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public AccountDTO searchAccountByColumn(String columnName, String input) throws SQLException {
        String sql = "SELECT * FROM Account WHERE [" + columnName + "] = ?";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, input);
            rs = ptm.executeQuery();
            while (rs.next()) {
                AccountDTO account = new AccountDTO();
                account.setAccountID(rs.getString(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setFullname(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setEmail(rs.getString(6));
                account.setAddress(rs.getString(7));
                account.setRole(rs.getInt(8));
                account.setAccountStatus(rs.getInt(9));
                return account;
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

    public List<AccountDTO> getAllAccount() throws SQLException {
        String sql = "SELECT * FROM Account";
        ArrayList<AccountDTO> la = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                AccountDTO account = new AccountDTO();
                account.setAccountID(rs.getString(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setFullname(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setEmail(rs.getString(6));
                account.setAddress(rs.getString(7));
                account.setRole(rs.getInt(8));
                account.setAccountStatus(rs.getInt(9));
                la.add(account);
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
        return la;
    }

    public AccountDTO getAccountByID(String accountID) throws SQLException {
        String sql = "SELECT * FROM Account WHERE AccountID = ?";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, accountID);
            rs = ptm.executeQuery();
            if (rs.next()) {
                AccountDTO account = new AccountDTO();
                account.setAccountID(rs.getString(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setFullname(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setEmail(rs.getString(6));
                account.setAddress(rs.getString(7));
                account.setRole(rs.getInt(8));
                account.setAccountStatus(rs.getInt(9));
                return account;
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
        return null; // Return null if no account with the specified ID is found
    }

    public void changeStatusAccount(String id, int status) throws SQLException {
        String sql = "UPDATE Account SET [Status] = ? WHERE AccountID = ?";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, status);
            ptm.setString(2, id);
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
