package com.example.spring;

import com.example.spring.database.domain.Team;
import com.example.spring.database.domain.User;
import com.example.spring.repository.TeamRepository;
import com.example.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    private final TeamRepository teamRepository;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        Team team = Team.builder().name("개발팀").build();
        teamRepository.save(team);

        User user = User.builder().name("kennen").age(37).team(team).build();
        userRepository.save(user);
    }
}
