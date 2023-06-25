package com.example28;

import java.util.ArrayList;

public interface EmployeeService {

    Employee minimumSalary(int departmentId);

    Employee maxSalary(int departmentId);

    ArrayList<Employee> departmentsAll(int departmentId);

    ArrayList<Employee> All();
}