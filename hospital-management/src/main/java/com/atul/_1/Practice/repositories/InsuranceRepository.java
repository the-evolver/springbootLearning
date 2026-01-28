package com.atul._1.Practice.repositories;

import com.atul._1.Practice.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance , Long> {

}
