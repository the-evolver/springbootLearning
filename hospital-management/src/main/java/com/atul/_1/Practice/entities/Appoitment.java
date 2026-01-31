package com.atul._1.Practice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appoitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @CreationTimestamp
    private LocalDateTime appoitmentTime;

    @Column(nullable = false ,length = 25)
    private String reason;

    private String status;

    @ManyToOne
    private Doctor doctor_id;

    @ManyToOne
    private Patient patient_id;






}
