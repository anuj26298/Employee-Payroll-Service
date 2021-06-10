package com.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    private List<EmployeeData> employeePayrollDataList;

    public EmployeePayrollService(List<EmployeeData> employeePayrollDataList) {
        this.employeePayrollDataList = employeePayrollDataList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<EmployeeData> employeeDataList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeeDataList);
        employeePayrollService.readEmployeePayrollData(scanner);
        employeePayrollService.writeEmployeePayrollData();
    }

    private void readEmployeePayrollData(Scanner scanner){
        System.out.println("Enter Employee ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = scanner.next();
        System.out.println("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        employeePayrollDataList.add(new EmployeeData(id,name,salary));
    }
    private void writeEmployeePayrollData(){
        System.out.println("----Employee Data----\n" + employeePayrollDataList);
    }

}
