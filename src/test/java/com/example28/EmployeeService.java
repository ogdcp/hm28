package com.example28;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee minimumSalary(int departmentId);

    Employee maxSalary(int departmentId);

    ArrayList<Employee> departmentsAll(int departmentId);

    Map<Integer, List<Employee>> All();

    @GetMapping("/all")
    ArrayList<Employee> all();
}