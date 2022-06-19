package com.example.spring.repository;

import com.example.spring.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    RefreshToken findByToken(String token);

    @Modifying
    @Query("UPDATE RefreshToken token set token.token = :token, token.expiredDate = :expiryDate where token.id = :id")
    void updateToken(@Param("id") Long id, @Param("token") String token, @Param("expiryDate") Instant expiryDate);
}
