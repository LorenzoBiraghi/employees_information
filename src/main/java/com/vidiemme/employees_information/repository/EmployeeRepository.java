package com.vidiemme.employees_information.repository;

import com.vidiemme.employees_information.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * Find employee by his username
     * @param username
     * @return Employee object
     */
    public Optional<Employee> findByUsername(String username);
    public void deleteByUsername(String username);
}
