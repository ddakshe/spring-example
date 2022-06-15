package com.example.spring;

import com.example.spring.config.TestDataSourceConfig;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
@Import(TestDataSourceConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class BaseDataJpaTests {

    @PersistenceContext
    protected EntityManager entityManager;

    protected JPAQueryFactory query;


    @PostConstruct
    private void initJpaQueryFactory(){
        query = new JPAQueryFactory(entityManager);
    }

}
