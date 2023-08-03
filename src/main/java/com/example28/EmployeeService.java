package com.example28;

import java.util.List;

public interface EmployeeService {
    Employee addPerson(String name, String lastName, int salary, int department) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    Employee deletePerson(String name, String lastName) throws EmployeeNotFoundException;

    Employee findPerson(String name, String lastName) throws EmployeeNotFoundException;

    List<Employee> showAllPersons();
}
