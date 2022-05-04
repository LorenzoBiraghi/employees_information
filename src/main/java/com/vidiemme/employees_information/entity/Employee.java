package com.vidiemme.employees_information.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @NotBlank(message = "empty")
    public String fistname;

    @NotNull
    @NotBlank(message = "empty")
    public String lastname;

    @Email
    public String email;

    public String phone;

    public Date birth_date;

    @NotNull
    @NotBlank(message = "empty")
    public String username;

    @NotNull
    @NotBlank(message = "empty")
    public String password;
}