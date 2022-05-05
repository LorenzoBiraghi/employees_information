package com.vidiemme.employees_information.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vidiemme.employees_information.entity.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String firstname;

    @Column
    public String lastname;

    @Email
    public String email;

    @Column
    public String phone;

    @Column(name = "birth_date")
    public Date birthDate;

    @NotNull
    @NotBlank(message = "empty")
    public String username;

    @JsonIgnore
    public String password;

    @ManyToMany
    @JoinTable(name = "employees_roles",joinColumns =
        @JoinColumn(name = "employee_id", referencedColumnName = "id"), inverseJoinColumns =
        @JoinColumn(name = "role_id", referencedColumnName = "id"))
    public List<Role> roles;


    public Employee(EmployeeDto employeeDto){
        this.id = employeeDto.getId();
        this.username = employeeDto.getUsername();
        this.password = employeeDto.getPassword();
        this.birthDate = employeeDto.getBirthDate();
        this.roles = employeeDto.getRoles();
        this.email = employeeDto.getEmail();
        this.firstname = employeeDto.getFirstname();
        this.lastname = employeeDto.getLastname();
        this.phone = employeeDto.getPhone();
    }
}
