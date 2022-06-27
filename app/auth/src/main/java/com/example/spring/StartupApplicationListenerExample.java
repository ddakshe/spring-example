package com.example.spring;

import com.example.spring.domain.Role;
import com.example.spring.domain.User;
import com.example.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile("auth-test")
public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        String password = passwordEncoder.encode("12345678");
        User user = User.builder().email("ddakshe@gmail.com").name("kennen")
                .password(password).age(37).role(Role.ROLE_USER).build();
        userRepository.save(user);
    }
}
