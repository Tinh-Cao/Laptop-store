/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package untils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {
    private static final String DB = "PRJ_LAPTOP";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "12345";
    public static Connection getConnection1() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB;
        conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }
    
     public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        Connection conn = null;
       Context context= new InitialContext();
       Context end = (Context)context.lookup("java:comp/env");
       DataSource ds = (DataSource) end.lookup("DBCon");
       conn =ds.getConnection();
        return conn;
    }
}

