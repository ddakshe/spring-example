package com.example.spring.jwt;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private final JwtUserDetails userDetails;

    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, JwtUserDetails userDetails) {
        super(principal, credentials, authorities);
        this.userDetails = userDetails;
    }
}
