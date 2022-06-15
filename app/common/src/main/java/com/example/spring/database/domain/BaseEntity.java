package com.example.spring.database.domain;


import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.ZonedDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private ZonedDateTime createdDate;

    private ZonedDateTime modifiedDate;

    @PrePersist
    public void createDate() {
        createdDate = ZonedDateTime.now();
        modifiedDate = createdDate;
    }

    @PreUpdate
    public void updateDate(){
        modifiedDate = ZonedDateTime.now();
    }

}
