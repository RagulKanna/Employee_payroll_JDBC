package com.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeRepo {
    public static void main(String[] args) {
        getConnection();
    }
    private static Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/payroll_service";
        String userName = "root";
        String password = "1234";
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}