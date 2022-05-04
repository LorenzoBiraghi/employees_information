package com.vidiemme.employees_information.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "skills&competences")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SkillAndCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String typology;

    @Column
    public String description;
}
