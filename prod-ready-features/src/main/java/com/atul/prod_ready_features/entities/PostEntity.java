package com.atul.prod_ready_features.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Service
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String operation;

    private LocalDateTime updateTime;

    @PrePersist
    public void beforeCreation(){
         jpaAuditing("create");
    }
    @PreUpdate
    public void beforeUpdate(){
        jpaAuditing("update");
    }
    @PreRemove
    public void beforeDelete(){
        jpaAuditing("delete");
    }

    private void jpaAuditing(String currOperation) {
         setOperation(currOperation);
         setUpdateTime(LocalDateTime.now());
    }
}
