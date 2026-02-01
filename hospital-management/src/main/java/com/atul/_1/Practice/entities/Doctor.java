package com.atul._1.Practice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Lallu doctor not allowed
    private String specialization;

    @Column(name = "official_email",unique = true)
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(name="doctor_department",joinColumns = { @JoinColumn(name = "doctor_id"),} ,inverseJoinColumns = { @JoinColumn(name = "department_id"),})
    private List<Department> departments = new ArrayList<>();


}
