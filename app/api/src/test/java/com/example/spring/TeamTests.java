package com.example.spring;

import com.example.spring.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@DataJpaTest
@EnableJpaRepositories
public class TeamTests extends BaseDataJpaTests {

    @Autowired
    private TeamRepository teamRepository;

}
