package com.example28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EmployeeServiceImplTest {
    EmployeeServiceImpl employeeService;

    List<Employee> staff = new ArrayList<>(List.of());


    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("Чернов", "Данила", 90_000, 1);
        Employee employee2 = new Employee("Григорьев", "Олег", 60_000, 2);
        Employee employee3 = new Employee("Беляев", "Максим", 80_000, 1);
        Employee employee4 = new Employee("Александров", "Кирилл", 99_000, 3);
        staff.add(employee1);
        staff.add(employee2);
        staff.add(employee3);
        staff.add(employee4);
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void addPerson() throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        String name = "Ivan";
        String lastName = "Ivanov";
        int salary = 120000;
        int department = 1;

        Employee act = employeeService.addPerson(name, lastName, salary, department);

        Employee employee = new Employee("Ivan", "Ivanov", 120000, 1);
        staff.add(employee);
        Employee ex = staff.get(staff.indexOf(employee));

        assertEquals(act, ex);
    }

    @Test
    void deletePerson() throws EmployeeNotFoundException {
        String lastName = "Данила";
        String name = "Чернов";

        employeeService.findPerson(name, lastName);

        employeeService.deletePerson(name, lastName);

        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeService.findPerson(name, lastName));
    }

    @Test
    void findPerson() throws EmployeeNotFoundException {
        String lastName = "Данила";
        String name = "Чернов";


        Employee act = employeeService.findPerson(name, lastName);

        Employee ex = staff.stream()
                .filter(test -> ((test.getName().equals("Чернов")) && (test.getLastName().equals("Данила"))))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Такого сотрудника нет"));

        assertEquals(act, ex);
    }

    @Test
    void showAllPersons() {
        List<Employee> act = employeeService.showAllPersons();

        List<Employee> ex = staff;

        assertEquals(act,ex);
    }
}