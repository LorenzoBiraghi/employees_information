package com.vidiemme.employees_information.entity.dto;

import com.vidiemme.employees_information.entity.Employee;
import com.vidiemme.employees_information.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String phone;

    private Date birthDate;

    private String username;

    private String password;

    private List<Role> roles;

    public EmployeeDto(Employee employee){
        this.id = employee.getId();
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        this.email = employee.getEmail();
        this.phone = employee.getPhone();
        this.birthDate = employee.getBirthDate();
        this.username = employee.getUsername();
        this.password = employee.getPassword();
        this.roles = employee.getRoles();
    }
}
