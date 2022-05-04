package com.vidiemme.employees_information.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "language_skills")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LanguageSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String language;

    public String writing_comprehension;

    public String listening_comprehension;

    public String writing_exposure;

    public String listening_exposure;
}
