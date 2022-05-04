package com.vidiemme.employees_information.repository;

import com.vidiemme.employees_information.entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {
}
