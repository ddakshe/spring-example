package com.example.spring.domain;

import com.example.spring.config.TestDataSourceConfig;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@Import(TestDataSourceConfig.class)
@AutoConfigureTestDatabase(replace = Replace.ANY) // 스키마 사용을 위해
public class BaseDataJpaTests {

    @PersistenceContext
    protected EntityManager entityManager;

    protected JPAQueryFactory query;


    public BaseDataJpaTests() {
        System.out.println("entityManager = " + entityManager);
    }

    @PostConstruct
    private void initJpaQueryFactory(){
        query = new JPAQueryFactory(entityManager);
    }

}
