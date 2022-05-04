package com.vidiemme.employees_information.service.api;

import com.vidiemme.employees_information.entity.Employee;
import com.vidiemme.employees_information.entity.dto.EmployDto;
import com.vidiemme.employees_information.entity.dto.EmployeeUsernamePassword;
import com.vidiemme.employees_information.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class EmployeeApiService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    EmployeeRepository employeeRepository;


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
    public Employee save(EmployDto employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Employee employee1 = new Employee(employee.getId(), employee.getFirstname(),
                employee.getLastname(), employee.getEmail(), employee.getPhone(),
                employee.getBirthDate(), employee.getUsername(), employee.getPassword(), employee.getRoles());
        employeeRepository.save(employee1);
        return employee1;
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
     * Update password of employee by his username
     * @param employee Object based by username and password
     * @param username
     * @return Employee object updated
     */
    public Employee updatePasswordByUsername(EmployeeUsernamePassword employee, String username){
        Optional<Employee> employeeOptional = employeeRepository.findByUsername(username);
        if(employeeOptional.isEmpty()){
            return null;
        }
        else{
            EmployDto employDto = new EmployDto();
            employDto.setUsername(employee.getUsername());
            employDto.setPassword(employee.getPassword());
            save(employDto);
            return employeeOptional.get();
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        if(employee.isEmpty()){
            String message = "Employee non found with username: " + username;
            log.error(message);
            throw new UsernameNotFoundException(message);
        }
        else{
            log.debug("Employee found in the database: {}", username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            employee.get().roles.stream().forEach(role ->
                    authorities.add(new SimpleGrantedAuthority(role.getName())));
            return new org.springframework.security.core.userdetails.User(employee.get().username, employee.get().password, authorities);


        }
    }
}
