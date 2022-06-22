package com.example.employeemanager.services;

import com.example.employeemanager.models.Employee;
import java.util.List;

public interface IEmployeeService {
    
    Employee newEmployee(Employee employee);

    List<Employee> findAllEmployee();

    Employee findEmployeeById(Long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

}
