package com.example.spring.api.repository;

import com.example.spring.domain.BaseDataJpaTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@DataJpaTest
@EnableJpaRepositories
public class TeamTests extends BaseDataJpaTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TeamRepository teamRepository;

}
