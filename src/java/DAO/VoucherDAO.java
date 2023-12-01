/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import untils.DBUtils;
import DTO.Voucher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class VoucherDAO extends DBUtils {

    public List<Voucher> listVoucher() {
        String sql = "SELECT [VoucherID]\n"
                + "      ,[Name]\n"
                + "      ,[VoucherCode]\n"
                + "      ,[StartDate]\n"
                + "      ,[EndDate]\n"
                + "      ,[Discount]\n"
                + "      ,[Quantity]\n"
                + "  FROM [dbo].[Voucher]";
        List<Voucher> lv = new ArrayList<>();
         Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Voucher v = new Voucher();
                v.setVourcherID(rs.getInt(1));
                v.setName(rs.getString(2));
                v.setVoucherCode(rs.getString(3));
                v.setStart(rs.getString(4));
                v.setEnd(rs.getString(5));
                v.setDiscount(rs.getInt(6));
                v.setQuantity(rs.getInt(7));
                lv.add(v);
            }
        } catch (Exception e) {
        }
        return lv;
    }

    public void addVoucher(String name, String code, String start, String end, int discount, int quantity) {
        String sql = "INSERT INTO [dbo].[Voucher]\n"
                + "           ([Name]\n"
                + "           ,[VoucherCode]\n"
                + "           ,[StartDate]\n"
                + "           ,[EndDate]\n"
                + "           ,[Discount]\n"
                + "           ,[Quantity])\n"
                + "     VALUES (?,?,?,?,?,?)";
          Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, code);
            ps.setString(3, start);
            ps.setString(4, end);
            ps.setInt(5, discount);
            ps.setInt(6, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
