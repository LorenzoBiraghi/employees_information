package com.vidiemme.employees_information.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "it_skills")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ITSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String technology;

    public String self_evaluation;

    public String description;
}
