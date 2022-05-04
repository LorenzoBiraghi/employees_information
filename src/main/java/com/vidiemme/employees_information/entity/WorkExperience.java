package com.vidiemme.employees_information.entity;

import javax.persistence.*;
import java.time.Year;

@Entity
@Table(name = "work_experiences")
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String agency;

    public String sector;

    public String position;

    public String description;

    public Year start_year;

    public Year finish_year;
}
