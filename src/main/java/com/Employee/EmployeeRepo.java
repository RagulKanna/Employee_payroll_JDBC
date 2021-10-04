package com.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {

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

    public void insertData(EmployeeInfo info) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "insert into employee_payroll(name,salary,startdate,gender) " +
                    "values ('" + info.getName() + "'," + info.getSalary() + "," +
                    "'" + info.getStartDate() + "','" + info.getGender() + "'); ";
            int result = statement.executeUpdate(sql);
            if (result == 1) {
                System.out.println("insert query");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public List<EmployeeInfo> retrieveData() {
        ResultSet resultSet = null;
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from employee_payroll where id=4";
            resultSet = statement.executeQuery(sql);
            int count = 1;
            while (resultSet.next()) {
                count++;
                EmployeeInfo employeeInfo = new EmployeeInfo();
                employeeInfo.setId(resultSet.getInt("id"));
                employeeInfo.setName(resultSet.getString("name"));
                employeeInfo.setSalary(resultSet.getInt("salary"));
                employeeInfo.setStartDate(resultSet.getDate("startdate").toLocalDate());
                employeeInfo.setGender(resultSet.getString("gender").charAt(0));

                employeeInfoList.add(employeeInfo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeInfoList;
    }
}