package com.example.spring;

import com.example.spring.api.repository.TeamRepository;
import com.example.spring.api.repository.UserRepository;
import com.example.spring.domain.Team;
import com.example.spring.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;

    private final TeamRepository teamRepository;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        Team team = Team.builder().name("개발팀").build();
        teamRepository.save(team);

        User user = User.builder().name("kennen").age(37).build();
        user.setTeam(team);
        userRepository.save(user);
    }
}
