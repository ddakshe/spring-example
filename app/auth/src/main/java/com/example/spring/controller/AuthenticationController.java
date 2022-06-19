package com.example.spring.controller;

import com.example.spring.*;
import com.example.spring.domain.RefreshToken;
import com.example.spring.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final RefreshTokenService refreshTokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, RefreshTokenService refreshTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getId(), loginRequest.getPw()));
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        SpringUserDetails tokenUserDetails = jwtAuthenticationToken.getUserDetails();

        JwtTokenInfo accessToken = jwtUtils.generateAccessToken(authentication.getName());
        JwtTokenInfo tokenInfo = jwtUtils.generateRefreshToken(authentication.getName());
        refreshTokenService.saveRefreshToken(tokenUserDetails.getUserId(), tokenInfo);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new LoginResponse(accessToken, tokenInfo));
    }

    @PostMapping("refresh-token")
    public ResponseEntity<?> refreshToken(@RequestParam String token){
        RefreshToken refreshToken = refreshTokenService.validateToken(token);

        User user = refreshToken.getUser();
        String username = user.getEmail();
        JwtTokenInfo generateAccessToken = jwtUtils.generateAccessToken(username);
        JwtTokenInfo generateRefreshToken = jwtUtils.generateRefreshToken(username);

        refreshTokenService.updateRefreshToken(user.getId(), generateRefreshToken.getToken(), generateRefreshToken.getExpiryDate());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new LoginResponse(generateAccessToken, generateRefreshToken));
    }

}
