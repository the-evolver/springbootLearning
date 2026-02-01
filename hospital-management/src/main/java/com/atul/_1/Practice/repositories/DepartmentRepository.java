package com.atul._1.Practice.repositories;

import com.atul._1.Practice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
