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

    @Column
    public String level;

    @Column(name = "school_name")
    public String schoolName;

    @Column
    public String city;

    @Column(name = "final_grade")
    public String finalGrade;

    @Column(name = "start_year")
    public Year startYear;

    @Column(name = "finish_year")
    public Year finishYear;
}
