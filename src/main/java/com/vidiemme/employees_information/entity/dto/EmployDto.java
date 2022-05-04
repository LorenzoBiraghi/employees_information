package com.vidiemme.employees_information.entity.dto;

import com.vidiemme.employees_information.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployDto {

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String phone;

    private Date birthDate;

    private String username;

    private String password;

    private List<Role> roles;
}
