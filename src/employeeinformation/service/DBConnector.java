/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeinformation.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

/**
 *
 * @author b
 */
public class DBConnector {

     static Connection conn = null;

    public static Connection getConnection() {
       
        if (conn == null) {
            String url = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6431541";
            String username = "sql6431541";
            String pass = "cR7nX9RzG3";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, pass);
                System.out.println("connection successful");

            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        }

        return conn;

    }

}
