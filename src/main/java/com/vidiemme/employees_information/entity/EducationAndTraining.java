package com.vidiemme.employees_information.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "education&training")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EducationAndTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String level;

    public String school_name;

    public String city;

    public String final_grade;

    public Year start_year;

    public Year finish_year;
}
