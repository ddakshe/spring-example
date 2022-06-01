package com.example.spring;

import com.example.spring.api.repository.UserRepository;
import com.example.spring.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {


    private final UserRepository userRepository;

    @Override public void onApplicationEvent(ContextRefreshedEvent event) {
        User user = User.builder().name("kennen").age(37).build();
        userRepository.save(user);
    }
}
