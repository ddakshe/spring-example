package com.example.spring;

import com.example.spring.domain.Role;
import com.example.spring.domain.Team;
import com.example.spring.domain.User;
import com.example.spring.repository.TeamRepository;
import com.example.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    private final TeamRepository teamRepository;

    private final PasswordEncoder passwordEncoder;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        Team team = Team.builder().name("개발팀").build();
        teamRepository.save(team);

        String password = passwordEncoder.encode("1234");
        User user = User.builder().email("ddakshe@gmail.com")
                .password(password).name("kennen").age(37).role(Role.ROLE_USER).team(team).build();
        userRepository.save(user);
    }
}
