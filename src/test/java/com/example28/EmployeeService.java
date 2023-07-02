package com.example28;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    @GetMapping("/min-salary")
    Employee minimumSalary(@RequestParam("departmentId") int departmentId);

    @GetMapping("/max-salary")
    Employee maxSalary(@RequestParam("departmentId") int departmentId);

    @GetMapping(value = "/аll", params = "departmentId")
    ArrayList<Employee> departmentsAll(@RequestParam("departmentId") int departmentId);

    @GetMapping("/all")
    Map<Integer, List<Employee>> all();
}
