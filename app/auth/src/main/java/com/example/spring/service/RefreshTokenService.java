package com.example.spring.service;

import com.example.spring.domain.RefreshToken;
import com.example.spring.jwt.JwtTokenInfo;
import com.example.spring.repository.RefreshTokenRepository;
import com.example.spring.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

@Service
@Transactional(readOnly = true)
public class RefreshTokenService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(UserRepository userRepository, RefreshTokenRepository refreshTokenRepository) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }
    public void saveRefreshToken(Long userId, JwtTokenInfo jwtTokenInfo) {
        userRepository.findById(userId)
                .ifPresent(user -> {
                    RefreshToken refreshToken = new RefreshToken(user, jwtTokenInfo.getToken(), jwtTokenInfo.getExpiryDate().toInstant());
                    refreshTokenRepository.save(refreshToken);
                });
    }

    public RefreshToken validateToken(String refreshToken) {
        RefreshToken token = refreshTokenRepository.findByToken(refreshToken);

        if (token == null) {
            throw new RuntimeException("Refresh Token is Not Exist");
        }

        if (token.getExpiredDate().isBefore(Instant.now())) {
            throw new RuntimeException("Refresh Token is expired");
        }

        return token;
    }

    @Transactional
    public void updateRefreshToken(Long id, String token, Date expiryDate) {
        refreshTokenRepository.updateToken(id, token, expiryDate.toInstant());
    }
}
