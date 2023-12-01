/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import untils.DBUtils;
import DTO.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author msi
 */
public class ProductDAO extends DBUtils {

    public List<ProductDTO> getAllProduct() throws SQLException {
        String sql = "SELECT * FROM Product p JOIN Category c on c.CategoryID = p.CategoryID";
        List<ProductDTO> lp = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setPname(rs.getString(3));
                product.setQuantity(rs.getInt(4));
                product.setPrice(rs.getInt(5));
                product.setRam(rs.getString(6));
                product.setStorage(rs.getString(7));
                product.setCpu(rs.getString(8));
                product.setVga(rs.getString(9));
                product.setStatus(rs.getInt(10));
                product.setImage(rs.getString(11));
                lp.add(product);
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
        return lp;
    }

    public List<ProductDTO> getAllProductDisplay() throws SQLException {
        String sql = "SELECT * FROM Product p JOIN Category c on c.CategoryID = p.CategoryID WHERE p.Status = 1 AND c.Status = 1";
        List<ProductDTO> lp = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setPname(rs.getString(3));
                product.setQuantity(rs.getInt(4));
                product.setPrice(rs.getInt(5));
                product.setRam(rs.getString(6));
                product.setStorage(rs.getString(7));
                product.setCpu(rs.getString(8));
                product.setVga(rs.getString(9));
                product.setStatus(rs.getInt(10));
                product.setImage(rs.getString(11));
                lp.add(product);
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
        return lp;
    }

    public ProductDTO getProductByID(int id) throws SQLException {
        String sql = "SELECT * FROM Product WHERE ProductID = " + id;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            if (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setPname(rs.getString(3));
                product.setQuantity(rs.getInt(4));
                product.setPrice(rs.getInt(5));
                product.setRam(rs.getString(6));
                product.setStorage(rs.getString(7));
                product.setCpu(rs.getString(8));
                product.setVga(rs.getString(9));
                product.setStatus(rs.getInt(10));
                product.setImage(rs.getString(11));
                return product;
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

    public void addProduct(int CateID, String name, int quantity, double price, String ram, String storage, String cpu, String vga, int Status, String image) throws SQLException {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "([CategoryID]\n"
                + ",[Name]\n"
                + "           ,[QuantityAvailable]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[RamCapacity]\n"
                + "           ,[StorageCapacity]\n"
                + "           ,[CpuBrand]\n"
                + "           ,[VgaBrand]\n"
                + "           ,[Status], [Image])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?)";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, CateID);
            ptm.setString(2, name);
            ptm.setInt(3, quantity);
            ptm.setDouble(4, price);
            ptm.setString(5, ram);
            ptm.setString(6, storage);
            ptm.setString(7, cpu);
            ptm.setString(8, vga);
            ptm.setInt(9, Status);
            ptm.setString(10, image);
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

    public void updateProduct(int productId, int categoryId, String name, int quantity, double price, String ram, String storage, String cpu, String vga, String image) throws SQLException {
        String sql = "UPDATE [dbo].[Product] SET "
                + "[CategoryID] = ?, "
                + "[Name] = ?, "
                + "[QuantityAvailable] = ?, "
                + "[UnitPrice] = ?, "
                + "[RamCapacity] = ?, "
                + "[StorageCapacity] = ?, "
                + "[CpuBrand] = ?, "
                + "[VgaBrand] = ?,"
                + "[Image] = ? "
                + "WHERE [ProductID] = ?";

        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, categoryId);
            ptm.setString(2, name);
            ptm.setInt(3, quantity);
            ptm.setDouble(4, price);
            ptm.setString(5, ram);
            ptm.setString(6, storage);
            ptm.setString(7, cpu);
            ptm.setString(8, vga);
            ptm.setString(9, image);
            ptm.setInt(10, productId);

            ptm.executeUpdate();
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
    }

    public List<ProductDTO> getProductByCategory(int id) throws SQLException {
        String sql = "SELECT p.ProductID, p.Name, p.QuantityAvailable, p.UnitPrice, p.UnitPrice, p.RamCapacity, p.StorageCapacity, p.VgaBrand, p.Image FROM Product p\n"
                + "JOIN Category c\n"
                + "ON c.CategoryID = p.CategoryID \n"
                + "WHERE c.CategoryID = ?";
        List<ProductDTO> lp = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, id);
            rs = ptm.executeQuery();
            while (rs.next()) {
                ProductDTO pro = new ProductDTO();
                pro.setProductID(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setQuantity(rs.getInt(3));
                pro.setPrice(rs.getInt(4));
                pro.setRam(rs.getString(5));
                pro.setStorage(rs.getString(6));
                pro.setCpu(rs.getString(7));
                pro.setVga(rs.getString(8));
                pro.setImage(rs.getString(9));
                lp.add(pro);
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
        return lp;
    }

    public List<ProductDTO> searchByKey(String key) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE Name LIKE '%" + key + "%'";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setPname(rs.getString(3));
                product.setQuantity(rs.getInt(4));
                product.setPrice(rs.getInt(5));
                product.setRam(rs.getString(6));
                product.setStorage(rs.getString(7));
                product.setCpu(rs.getString(8));
                product.setVga(rs.getString(9));
                product.setImage(rs.getString(11));
                list.add(product);
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
        return list;
    }

    public List<ProductDTO> filterProducts(String name, String brandCPU, String storage, String ram, String vga) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM dbo.Product p WHERE 1 = 1");
        List<ProductDTO> lp = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {

            if (name != null && !name.isEmpty()) {
                sql.append(" AND p.Name LIKE '%" + name + "%'");
            }

            if (brandCPU != null && !brandCPU.isEmpty()) {
                sql.append(" AND p.CpuBrand LIKE '%" + brandCPU + "%'");
            }

            if (storage != null && !storage.isEmpty()) {
                sql.append(" AND p.StorageCapacity LIKE '%" + storage + "%'");
            }

            if (ram != null && !ram.isEmpty()) {
                sql.append(" AND p.RamCapacity LIKE '%" + ram + "%'");
            }
            if (vga != null && !vga.isEmpty()) {
                sql.append(" AND p.VgaBrand LIKE '%" + vga + "%'");
            }
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql.toString());
            rs = ptm.executeQuery();

            while (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setPname(rs.getString(3));
                product.setQuantity(rs.getInt(4));
                product.setPrice(rs.getDouble(5));
                product.setRam(rs.getString(6));
                product.setStorage(rs.getString(7));
                product.setCpu(rs.getString(8));
                product.setVga(rs.getString(9));
                product.setImage(rs.getString(11));
                lp.add(product);
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

        return lp;
    }

    public void changeStatusProduct(int id, int status) throws SQLException {
        String sql = "UPDATE Product SET [Status] = ? WHERE ProductID = ?";
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

   public List<ProductDTO> findProductsByPage(int page, String keyword) throws SQLException, ClassNotFoundException, NamingException {
    String sql = "SELECT * FROM Product WHERE Name LIKE ? ORDER BY ProductID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    List<ProductDTO> productList = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ptm = null;
    ResultSet rs = null;

    try {
        conn = DBUtils.getConnection();
        if (conn != null) {
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, "%" + keyword + "%");
            ptm.setInt(2, (page - 1) * 8);
            ptm.setInt(3, 8);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("ProductID");
                int categoryID = rs.getInt("CategoryID");
                String pname = rs.getString("Name");
                int quantity = rs.getInt("QuantityAvailable");
                double price = rs.getDouble("UnitPrice"); // Replace with the actual column name for price
                String ram = rs.getString("RamCapacity");
                String storage = rs.getString("StorageCapacity");
                String cpu = rs.getString("CpuBrand");
                String vga = rs.getString("VgaBrand");
                int status = rs.getInt("Status");
                String image = rs.getString("Image");

                ProductDTO product = new ProductDTO(productID, categoryID, pname, quantity, price, ram, storage, cpu, vga, status);
                product.setImage(image);
                productList.add(product);
            }
        }
    } catch (SQLException e) {
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

    return productList;
}


    public int findTotalRecord(String keyword) throws SQLException, ClassNotFoundException, NamingException {
        String sql = "SELECT COUNT(*) FROM Product WHERE Name LIKE ?";
        int totalRecord = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, "%" + keyword + "%");
                rs = ptm.executeQuery();

                if (rs.next()) {
                    totalRecord = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
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
        return totalRecord;
    }
}
