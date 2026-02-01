package com.atul._1.Practice;

import com.atul._1.Practice.entities.*;
import com.atul._1.Practice.repositories.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

class HospitalManagementApplicationTests {

    @Autowired
    private  InsuranceRepository insuranceRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppoitmentRepository appoitmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

	@Test
	void contextLoads() {
	}

    @Test
    @Transactional
    @Rollback(false)
    void testEntitles(){

 //       This ordering is fine like in curr relationship parent (one-to-one) insurance ,and parent owns the relationship
 //       so this order we create the inverse side first this will not give error and looks good logically

//        Insurance insurance = Insurance.builder()
//                              .policyNumber("LIC-2000")
//                               .provider("LIC")
//                              .validUntil(LocalDate.of(2032, 9, 5)).build();
//
//        Insurance savedInsurance= insuranceRepository.save(insurance);
//
//        Patient patient = Patient.builder().name("sam-teja").gender(Gender.MALE).
//                birthDate(LocalDate.of(2011, 9, 8)).
//                email("sam@example.com").
//                bloodGroup(BloodGroups.ABpos).build();
//
//        patient.setInsurance(savedInsurance);
//
//        patientRepository.save(patient);

/// ///==============================================================================
//
//        Patient patient = Patient.builder().name("sam-teja-1").gender(Gender.MALE).
//                birthDate(LocalDate.of(2010, 9, 8)).
//                email("sam1@example.com").
//                bloodGroup(BloodGroups.ABpos).build();
//
//        patientRepository.save(patient); // persistent state ...
//
//                Insurance insurance = Insurance.builder()
//                              .policyNumber("LIC-3000")
//                               .provider("LIC")
//                              .validUntil(LocalDate.of(2033, 9, 5)).build();
//
//        Insurance savedInsurance= insuranceRepository.save(insurance); // persistent state
//
//        patient.setInsurance(savedInsurance);


//        Insurance insurance = Insurance.builder()
//                              .policyNumber("LIC-1003")
//                               .provider("LIC")
//                              .validUntil(LocalDate.of(2041, 9, 5)).build();
//
//        Patient patient = patientRepository.findById(2L).orElseThrow();
//        patient.setInsurance(insurance);

//        Patient patient = patientRepository.findById(2L).orElseThrow();
//
//        System.out.println(patient.getInsurance());



//            Insurance insurance = insuranceRepository.findById(3L).orElseThrow();
//            System.out.println(insurance);

//        patientRepository.deleteById(3L);
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
//        patientRepository.save(p1);

//        Patient p2 = new Patient();
//        p2.setName("Patient 2");
//        p2.setInsurance(insurance);
//
//        patientRepository.save(p2);



    }


    @Transactional
    @Rollback(false)
    @Test
    void testPatientInsuranceOneToOne() {

        Insurance insurance = new Insurance();
        insurance.setPolicyNumber("POL-500");
        insurance.setProvider("LIC");
        insuranceRepository.save(insurance);

        Patient patient = new Patient();
        patient.setName("Atul");
        patient.setInsurance(insurance);
        patientRepository.save(patient);

        Patient fetched = patientRepository.findById(patient.getId()).orElseThrow();

        assertNotNull(fetched.getInsurance());
        assertEquals("POL-500", fetched.getInsurance().getPolicyNumber());
    }


    @Test
    @Transactional
    @Rollback(false)
    void testInsuranceCannotBeAssignedTwice() {

        Insurance insurance = new Insurance();
        insurance.setPolicyNumber("POL-600");
        insurance.setProvider("LIC");
        insuranceRepository.save(insurance);

        Patient p1 = new Patient();
        p1.setName("P1");
        p1.setInsurance(insurance);
        patientRepository.save(p1);

        Patient p2 = new Patient();
        p2.setName("P2");
        p2.setInsurance(insurance);

        assertThrows(Exception.class, () -> patientRepository.save(p2));
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testPatientAppointmentRelation() {

        Patient patient = new Patient();
        patient.setName("Rahul-1");
        patientRepository.save(patient);

        Appoitment appointment = new Appoitment();
        appointment.setPatient(patient);
        appointment.setReason("Fever");
        appoitmentRepository.save(appointment);

        Appoitment fetched = appoitmentRepository.findById(appointment.getId()).orElseThrow();

        assertEquals(patient.getId(), fetched.getPatient().getId());
    }

    @Test
    void testDeletePatientDoesDeleteAppointment() {

        Patient patient = new Patient();
        patient.setName("Test-atul");
        patientRepository.save(patient);

        Appoitment appointment = new Appoitment();
        appointment.setPatient(patient);
        appointment.setReason("fever-atul");
        appoitmentRepository.save(appointment);

        patientRepository.delete(patient);

        assertFalse(appoitmentRepository.existsById(appointment.getId()));
    }

    @Test
    void testDoctorAppointmentRelation() {

        Doctor doctor = new Doctor();
        doctor.setName("Dr. Smith");
        doctorRepository.save(doctor);

        Appoitment appointment = new Appoitment();
        appointment.setDoctor(doctor);
        appointment.setReason("Fever104");
        appoitmentRepository.save(appointment);

        Appoitment fetched = appoitmentRepository.findById(appointment.getId()).orElseThrow();

        assertEquals(doctor.getId(), fetched.getDoctor().getId());
    }

    @Test
    void testDepartmentHeadDoctor() {

        Doctor doctor = new Doctor();
        doctor.setName("Dr. Head");
        doctorRepository.save(doctor);

        Department department = new Department();
        department.setName("Cardiology");
        department.setHead_doctor_id(doctor);
        departmentRepository.save(department);

        Department fetched = departmentRepository.findById(department.getId()).orElseThrow();

        assertEquals(doctor.getId(), fetched.getHead_doctor_id().getId());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testDoctorDepartmentManyToMany() {

        Doctor doctor = new Doctor();
        doctor.setName("Dr. Multi");
        doctorRepository.save(doctor);

        Department d1 = new Department();
        d1.setName("Neuro");
        departmentRepository.save(d1);

        Department d2 = new Department();
        d2.setName("Ortho");
        departmentRepository.save(d2);

        doctor.getDepartments().add(d1);
        doctor.getDepartments().add(d2);
        doctorRepository.save(doctor);

        Doctor fetched = doctorRepository.findById(doctor.getId()).orElseThrow();

        assertEquals(2, fetched.getDepartments().size());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testRemoveDepartmentFromDoctor() {

        Doctor doctor = doctorRepository.findAll().get(0);

        Department dept = doctor.getDepartments().get(0);
        doctor.getDepartments().remove(dept);

        doctorRepository.save(doctor);

        Doctor updated = doctorRepository.findById(doctor.getId()).orElseThrow();

        assertEquals(doctor.getDepartments().size(), updated.getDepartments().size());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void testOrphanRemovalInsurance() {

        Patient patient = new Patient();
        patient.setName("Test");
        Insurance newInsurance = Insurance.builder()
                .policyNumber("POL-700")
                .provider("LIC")
                .validUntil(LocalDate.now().plusYears(5))
                .build();

        patient.setInsurance(newInsurance);
        patientRepository.save(patient);

        Long insuranceId = patient.getInsurance().getId();

        patient.setInsurance(null);
        patientRepository.save(patient);

        assertFalse(insuranceRepository.existsById(insuranceId));
    }




}
