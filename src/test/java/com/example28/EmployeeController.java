package com.example28;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController

@RequestMapping("/departments")
public abstract class EmployeeController implements EmployeeService {


    private final EmployeeServiceImpl employeeService;
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/min-salary")
    @Override
    public Employee minimumSalary(@RequestParam("departmentId") int departmentId) {

        return employeeService.minimumSalary(departmentId);

    }
    @GetMapping("/max-salary")
    @Override
    public Employee maxSalary(@RequestParam("departmentId") int departmentId) {
        return employeeService.maxSalary(departmentId);
    }

    @GetMapping(value = "/аll", params = "departmentId")
    @Override
    public ArrayList<Employee> departmentsAll(@RequestParam("departmentId") int departmentId) {
        return employeeService.departmentsAll(departmentId);
    }
    @GetMapping("/all")
    @Override
    public Map<Integer, List<Employee>> all() {
        return employeeService.all();
    }
}
