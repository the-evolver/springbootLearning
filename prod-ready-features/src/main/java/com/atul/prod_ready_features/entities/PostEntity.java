package com.atul.prod_ready_features.entities;

import com.atul.prod_ready_features.auditing.AuditorImplementation;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
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
@EntityListeners(AuditingEntityListener.class)
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @CreatedDate
    @Column(name = "creation_date",nullable = false ,updatable = false)
    private long createdDate;

    @CreatedBy
    @Column(name = "created_by",nullable = false ,updatable = false)
    private String createdBy;


    @LastModifiedBy
    @Column(name = "updated_by",nullable = false )
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "updation_date",nullable = false )
    private long modifiedDate;



//    private String operation;
//
//    private LocalDateTime updateTime;
//
//    @PrePersist
//    public void beforeCreation(){
//         jpaAuditing("create");
//    }
//    @PreUpdate
//    public void beforeUpdate(){
//        jpaAuditing("update");
//    }
//    @PreRemove
//    public void beforeDelete(){
//        jpaAuditing("delete");
//    }
//
//    private void jpaAuditing(String currOperation) {
//         setOperation(currOperation);
//         setUpdateTime(LocalDateTime.now());
//    }


}
