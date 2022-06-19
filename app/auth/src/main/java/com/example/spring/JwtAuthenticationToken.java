package com.example.spring;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private final SpringUserDetails userDetails;
    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, SpringUserDetails userDetails) {
        super(principal, credentials, authorities);
        this.userDetails = userDetails;
    }
}
