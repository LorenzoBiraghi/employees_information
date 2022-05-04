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

    @Column
    public String language;

    @Column(name = "writing_comprehension")
    public String writingComprehension;

    @Column(name = "listening_comprehension")
    public String listeningComprehension;

    @Column(name = "writing_exposure")
    public String writingExposure;

    @Column(name = "listening_exposure")
    public String listeningExposure;
}
