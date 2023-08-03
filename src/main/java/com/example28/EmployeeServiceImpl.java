package com.example28;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int id = 10;
    List<Employee> staff = new ArrayList<>(List.of(
            new Employee("Чернов", "Данила", 90_000, 1),
            new Employee("Григорьев", "Олег", 60_000, 2),
            new Employee("Беляев", "Максим", 80_000, 1),
            new Employee("Александров", "Кирилл", 99_000, 3)
    ));

    @Override
    public Employee addPerson(String name, String lastName, int salary, int department) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee person = new Employee(name, lastName, salary, department);
        if (staff.size() > id) {
            throw new EmployeeStorageIsFullException("Робочие места заняты");
        } else if (staff.contains(person)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже на работе");
        } else {
            staff.add(person);
            return staff.get(staff.indexOf(person));
        }
    }

    @Override
    public Employee deletePerson(String name, String lastName) throws EmployeeNotFoundException {
        List<Employee> employees = new ArrayList<>();
        for(Employee i : staff){
            if((i.getName().equals(name)) && (i.getLastName().equals(lastName))){
                employees.remove(i);
                return (Employee) employees;
            }
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет");
    }

    @Override
    public Employee findPerson(String name, String lastName) throws EmployeeNotFoundException {
        List<Employee> employees = new ArrayList<>();
        for(Employee i : staff){
            if((i.getName().equals(name)) && (i.getLastName().equals(lastName))){
                employees.add(i);
                return (Employee) employees;
            }
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет");
    }
    @Override
    public List<Employee> showAllPersons() {
        return staff;
    }
}