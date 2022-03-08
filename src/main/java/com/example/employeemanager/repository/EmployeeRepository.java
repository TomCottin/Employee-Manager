package com.example.employeemanager.repository;

import com.example.employeemanager.models.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                 // Type de la classe et PRIMARY KEY
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long id);

}
