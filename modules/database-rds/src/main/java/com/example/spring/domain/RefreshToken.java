package com.example.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "spring")
public class RefreshToken extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private String token;

    private Instant expiredDate;

    public void setUser(User user) {
        this.user = user;
    }
}
