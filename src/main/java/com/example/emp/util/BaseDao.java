package com.example.emp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "tianrui", "000429");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close() {
        try {
            if (connection !=null)
                connection.close();
            connection =null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}