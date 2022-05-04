package com.vidiemme.employees_information.controller.api;

import com.vidiemme.employees_information.entity.Employee;
import com.vidiemme.employees_information.entity.dto.EmployDto;
import com.vidiemme.employees_information.entity.dto.EmployeeUsernamePassword;
import com.vidiemme.employees_information.service.api.EmployeeApiService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {
    @Autowired
    EmployeeApiService employeeApiService;

    /**
     * Get all Employees
     * @return List of Employees
     */
    @ApiResponse(description = "get employees",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeApiService.findAll();
        return ResponseEntity.ok(employees);
    }

    /**
     * Find Employee by his id
     * @param id
     * @return Employee object
     */
    @ApiResponse(description = "get employee by id",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeApiService.findById(id);
        if(employee != null){
            return ResponseEntity.ok(employee);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Find Employee by his username
     * @param username
     * @return Employee object
     */
    @ApiResponse(description = "get employee by username",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @GetMapping("/username/{username}")
    public ResponseEntity<Employee> getEmployeeByUsername(@PathVariable String username){
        Employee employee = employeeApiService.findByUsername(username);
        if(employee != null){
            return ResponseEntity.ok(employee);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Save Employee Object
     * @param employee
     * @return Employee object saved
     */
    @ApiResponse(description = "save employee",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @PostMapping("/")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployDto employee){
        return ResponseEntity.ok(employeeApiService.save(employee));
    }

    /**
     * Update Employee by his id
     * @param employee
     * @param id
     * @return Employee object updated
     */
    @ApiResponse(description = "update employee by id",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @PutMapping("/id/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee, @PathVariable Long id){
        Employee employeeupdated = employeeApiService.updateById(employee, id);
        if (employeeupdated != null){
            return ResponseEntity.ok(employeeupdated);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update Employee by his username
     * @param employee
     * @param username
     * @return Employee object updated
     */
    @ApiResponse(description = "update employee by username",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @PutMapping("/username/{username}")
    public ResponseEntity<Employee> updateEmployeeByusername(@Valid @RequestBody Employee employee, @PathVariable String username){
        Employee employeeupdated = employeeApiService.updateByUsername(employee, username);
        if (employeeupdated != null){
            return ResponseEntity.ok(employeeupdated);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update password of employee by his username
     * @param employee Object based by username and password
     * @param username
     * @return Employee object updated
     */
    @ApiResponse(description = "update password by username",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @PutMapping("/setPassword/{username}")
    public ResponseEntity<Employee> updateEmployeePasswordByusername(@RequestBody EmployeeUsernamePassword employee, @PathVariable String username){
        Employee employeeupdated = employeeApiService.updatePasswordByUsername(employee, username);
        if (employeeupdated != null){
            return ResponseEntity.ok(employeeupdated);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete all Employees
     * @return response code 200
     */
    @ApiResponse(description = "delete all employees",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @DeleteMapping("/")
    public ResponseEntity<Employee> deleteAllEmployees(){
        employeeApiService.deleteAll();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * Delete Employee by his id
     * @param id
     * @return Employee object deleted
     */
    @ApiResponse(description = "delete employee by id",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(Long id){
        Boolean check = employeeApiService.deleteById(id);
        if(Boolean.TRUE.equals(check)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete Employee by his username
     * @param username
     * @return Employee object deleted
     */
    @ApiResponse(description = "delete employee by username",responseCode = "200", content = @Content(schema = @Schema(implementation = Employee.class)))
    @DeleteMapping("/username/{username}")
    public ResponseEntity<Employee> deleteEmployeeByusername(String username){
        Boolean check = employeeApiService.deleteByUsername(username);
        if(Boolean.TRUE.equals(check)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
