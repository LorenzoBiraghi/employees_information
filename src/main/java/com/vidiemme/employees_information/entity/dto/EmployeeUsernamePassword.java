package com.vidiemme.employees_information.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeUsernamePassword {
    private String username;
    private String password;
}
