package com.example.spring.domain;


import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
