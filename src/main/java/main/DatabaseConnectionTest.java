/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    // Thông tin kết nối cơ sở dữ liệu
    static final String DB_URL = "jdbc:mysql://localhost:3306/quan_ly_ban_hang";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public static void main(String[] args) {

        Connection conn = null;
        try {
            // Đăng ký trình điều khiển JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Mở kết nối
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Kiểm tra kết nối
            if (conn != null) {
                System.out.println("Connected to database successfully!");
            } else {
                System.out.println("Failed to connect to database.");
            }

        } catch (SQLException se) {
            // Xử lý lỗi JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Xử lý lỗi Class.forName
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
}