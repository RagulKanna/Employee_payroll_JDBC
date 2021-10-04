package com.Employee;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollService {
    EmployeeRepo employeeRepo = new EmployeeRepo();

    public static void main(String[] args) throws SQLException {
        EmployeePayrollService service = new EmployeePayrollService();
        service.insertData();
        service.retrieveData();
    }

    private void insertData() {
        EmployeeInfo info = new EmployeeInfo();
        info.setName("kanna");
        info.setSalary(50000);
        info.setStartDate(LocalDate.of(2021, 01, 22));
        info.setGender('M');
        employeeRepo.insertData(info);
    }


    private void retrieveData() throws SQLException {
        List<EmployeeInfo> employeeInfoList = employeeRepo.retrieveData();
        System.out.println(employeeInfoList);
    }


}
