package com.atul._1.Practice;

import com.atul._1.Practice.entities.Insurance;
import com.atul._1.Practice.entities.Patient;
import com.atul._1.Practice.entities.type.BloodGroups;
import com.atul._1.Practice.entities.type.Gender;
import com.atul._1.Practice.repositories.InsuranceRepository;
import com.atul._1.Practice.repositories.PatientRepostory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest

class HospitalManagementApplicationTests {

    @Autowired
    private  InsuranceRepository insuranceRepository;

    @Autowired
    private  PatientRepostory patientRepostory;


	@Test
	void contextLoads() {
	}

    @Test
    @Transactional
    @Rollback(false)
    void testEntites(){

//        Insurance insurance = Insurance.builder()
//                              .policyNumber("LIC-1002")
//                               .provider("LIC")
//                              .validUntil(LocalDate.of(2031, 9, 5)).build();
//
//        Insurance savedInsurance= insuranceRepository.save(insurance);
//
//        Patient patient = Patient.builder().name("boba-teja").gender(Gender.MALE).
//                birthDate(LocalDate.of(2011, 9, 8)).
//                email("boba@example.com").
//                bloodGroup(BloodGroups.ABpos).build();
//
//        patient.setInsurance(savedInsurance);
//
//        patientRepostory.save(patient);

//        Insurance insurance = Insurance.builder()
//                              .policyNumber("LIC-1003")
//                               .provider("LIC")
//                              .validUntil(LocalDate.of(2041, 9, 5)).build();
//
//        Patient patient = patientRepostory.findById(2L).orElseThrow();
//        patient.setInsurance(insurance);

//        Patient patient = patientRepostory.findById(2L).orElseThrow();
//
//        System.out.println(patient.getInsurance());



//            Insurance insurance = insuranceRepository.findById(3L).orElseThrow();
//            System.out.println(insurance);

//        patientRepostory.deleteById(3L);
//
//        boolean insuranceExists =
//                insuranceRepository.existsById(3L);
//
//        System.out.println("Insurance still exists: " + insuranceExists);

//        Insurance insurance = insuranceRepository.findById(4L).orElseThrow();
//        System.out.println("Insurance " + insurance);
//        Patient p1 = new Patient();
//        p1.setName("Patient 1");
//        p1.setInsurance(insurance);
//        patientRepostory.save(p1);

//        Patient p2 = new Patient();
//        p2.setName("Patient 2");
//        p2.setInsurance(insurance);
//
//        patientRepostory.save(p2);



    }


}
