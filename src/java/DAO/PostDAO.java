/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import untils.DBUtils;
import DTO.PostDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class PostDAO extends DBUtils {

    public void addPost(int accountID, String title, String description, int type, String create, String banner) {
        String sql = "INSERT INTO [dbo].[Post]\n"
                + "           ([AccountID]\n"
                + "           ,[Title]\n"
                + "           ,[Description]\n"
                + "           ,[Type]\n"
                + "           ,[Created_date]\n"
                + "           ,[Banner])\n"
                + "     VALUES(?,?,?,?,?,?)";
       Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setInt(4, type);
            ps.setString(5, create);
            ps.setString(6, banner);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public PostDTO getPostByID(int id) {
        String sql = "SELECT p.PostID, a.Fullname, p.Title,p.Description,p.Type,p.Created_date FROM Post p\n"
                + "JOIN Account a ON p.AccountID = a.AccountID\n"
                + "WHERE p.PostID = ?";
      Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostDTO post = new PostDTO();
                post.setPostID(rs.getInt(1));
                post.setFullname(rs.getString(2));
                post.setTitle(rs.getString(3));
                post.setDescription(rs.getString(4));
                post.setType(rs.getInt(5));
                post.setCreate_date(rs.getString(6));
                return post;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<PostDTO> list3NewPost() {
        String sql = "SELECT TOP 3 p.PostID, a.Fullname, p.Title,p.Description,p.Type,p.Created_date FROM Post p\n"
                + "JOIN Account a ON p.AccountID = a.AccountID\n"
                + "ORDER BY p.PostID DESC";
        List<PostDTO> lpost = new ArrayList<>();
      Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostDTO post = new PostDTO();
                post.setPostID(rs.getInt(1));
                post.setFullname(rs.getString(2));
                post.setTitle(rs.getString(3));
                post.setDescription(rs.getString(4));
                post.setType(rs.getInt(5));
                post.setCreate_date(rs.getString(6));
                lpost.add(post);
            }
        } catch (Exception e) {
        }
        return lpost;
    }

    public static void main(String[] args) {
        PostDAO dao = new PostDAO();
        System.out.println(dao.list3NewPost().size());
    }
}
