package com.atul._1.Practice.entities;

import com.atul._1.Practice.entities.type.BloodGroups;
import com.atul._1.Practice.entities.type.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false ,length = 69)
    private  String name;

    @Enumerated(EnumType.STRING) // BY DEFAULT ORDINAL ISS DANGEROUS
    private  Gender gender;

    private LocalDate birthDate;

    @Column(unique = true)
    private  String email;

    @Enumerated(EnumType.STRING)
    private  BloodGroups bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // The table that contains the FOREIGN KEY is ALWAYS the OWNING SIDE.
    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)
    @JoinColumn(name = "insurance_id")

    private  Insurance insurance;





}
