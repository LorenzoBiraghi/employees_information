package com.vidiemme.employees_information.service.api;

import com.vidiemme.employees_information.entity.Employee;
import com.vidiemme.employees_information.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeApiService {
    @Autowired
    EmployeeRepository employeeRepository;
    PasswordEncoder passwordEncoder;


    /**
     * Find All Employees
     * @return List of Employees
     */
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    /**
     * Find Employee by his id
     * @param id
     * @return Employee object
     */
    public Employee findById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            return null;
        }
        else{
            return employee.get();
        }
    }

    /**
     * Find Employee by his username
     * @param username
     * @return Employee object
     */
    public Employee findByUsername(String username){
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        if(employee.isEmpty()){
            return null;
        }
        else{
            return employee.get();
        }
    }

    /**
     * Save Employee Object
     * @param employee
     * @return Employee object saved
     */
    public Employee save(Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.password));
        employeeRepository.save(employee);
        return employee;
    }

    /**
     * Update Employee by his id
     * @param employee
     * @param id
     * @return Employee object updated
     */
    public Employee updateById(Employee employee, Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()){
            return null;
        }
        else{
            employee.setId(id);
            employeeRepository.save(employee);
            return employee;
        }
    }

    /**
     * Update Employee by his username
     * @param employee
     * @param username
     * @return Employee object updated
     */
    public Employee updateByUsername(Employee employee, String username){
        Optional<Employee> employeeOptional = employeeRepository.findByUsername(username);
        if(employeeOptional.isEmpty()){
            return null;
        }
        else{
            employeeRepository.save(employee);
            return employee;
        }
    }

    /**
     * Delete all Employees
     */
    public void deleteAll(){
        employeeRepository.deleteAll();
    }

    /**
     * Delete Employee by his id
     * @param id
     * @return Employee object deleted
     */
    public Boolean deleteById(Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()){
            return false;
        }
        else{
            employeeRepository.deleteById(id);
            return true;
        }
    }

    /**
     * Delete Employee by his username
     * @param username
     * @return Employee object deleted
     */
    public Boolean deleteByUsername(String username){
        Optional<Employee> employeeOptional = employeeRepository.findByUsername(username);
        if(employeeOptional.isEmpty()){
            return false;
        }
        else{
            employeeRepository.deleteByUsername(username);
            return true;
        }
    }
}
