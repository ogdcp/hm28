package com.example28;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> staff = new ArrayList<>(List.of(
            new Employee("Максимов", "Данила", 60_000, 2),
            new Employee("Григорьев", "Олег", 50_000, 4),
            new Employee("Беляев", "Максим", 70_000, 2),
            new Employee("Александров", "Кирилл", 90_000, 1)
    ));

    @Override
    public Employee minimumSalary(int departmentId) {
        return  staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .min(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public Employee maxSalary(int departmentId) {
        return staff.stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .max(Comparator.comparing(Employee::getSalary))
                .get();
    }

    @Override
    public ArrayList<Employee> departmentsAll(int departmentId) {
        return (ArrayList<Employee>) staff
                .stream()
                .filter(d -> (d.getDepartment() == departmentId))
                .collect(Collectors.toList());

    }

    @Override
    public ArrayList<Employee> All() {
        return (ArrayList<Employee>) staff;
    }

}
