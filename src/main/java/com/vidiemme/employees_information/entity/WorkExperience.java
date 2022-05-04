package com.vidiemme.employees_information.entity;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "work_experiences")
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String agency;

    @Column
    public String sector;

    @Column
    public String position;

    @Column
    public String description;

    @Column(name = "start_year")
    public Year startYear;

    @Column(name = "finish_year")
    public Year finishYear;
}
