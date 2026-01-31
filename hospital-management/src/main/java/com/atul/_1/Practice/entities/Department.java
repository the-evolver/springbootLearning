package com.atul._1.Practice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    private Doctor head_doctor_id;

    @ManyToMany
    private List<Doctor> all_doctors_in_department;

}
