package com.atul._1.Practice.repositories;

import com.atul._1.Practice.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PatientRepostory extends JpaRepository<Patient, Long> {

}
