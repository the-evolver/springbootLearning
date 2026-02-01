package com.atul._1.Practice.repositories;

import com.atul._1.Practice.entities.Appoitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppoitmentRepository extends JpaRepository<Appoitment,Long> {

}
