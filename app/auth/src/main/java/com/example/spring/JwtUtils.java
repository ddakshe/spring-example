package com.example.spring;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.access-token-valid-time}")
    private int accessTokenExpirationMs;

    @Value("${jwt.refresh-token-valid-time}")
    private int refreshTokenExpirationMs;


    public JwtTokenInfo generateAccessToken(String username) {
        return generateToken(username, accessTokenExpirationMs);
    }

    public JwtTokenInfo generateRefreshToken(String username){
        return generateToken(username, refreshTokenExpirationMs);
    }

    private JwtTokenInfo generateToken(String username, int refreshTokenExpirationMs) {
        final Date now = new Date();
        Date expiration = new Date(now.getTime() + refreshTokenExpirationMs);
        String token = Jwts.builder().setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
        return new JwtTokenInfo(token, expiration);
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}