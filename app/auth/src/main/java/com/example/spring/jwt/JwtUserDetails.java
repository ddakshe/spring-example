package com.example.spring.jwt;

import com.example.spring.domain.Role;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class JwtUserDetails implements UserDetails {

    @Getter
    private final Long userId;
    @Getter
    private final String email;
    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities = new ArrayList<>();

    public JwtUserDetails(Long userId, String email, String username, Role role) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = null;
        this.authorities.add(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
