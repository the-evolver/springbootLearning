package com.atul._1.Practice.repositories;

import com.atul._1.Practice.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
