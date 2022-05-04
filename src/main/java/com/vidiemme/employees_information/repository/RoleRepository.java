package com.vidiemme.employees_information.repository;

import com.vidiemme.employees_information.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
