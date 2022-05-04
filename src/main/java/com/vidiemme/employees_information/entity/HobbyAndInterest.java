package com.vidiemme.employees_information.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hobbies&interests")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HobbyAndInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String description;
}
