package com.example.spring;

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
@AutoConfigureTestDatabase(replace = Replace.NONE) // 스키마 사용을 위해 테스트에서 사용하는 메모리 DB가 아닌 test/resources/application-aws.yml 에 있는 h2 config 를 사용한다.
public abstract class BaseDataJpaTests {
    @PersistenceContext
    protected EntityManager entityManager;
    protected JPAQueryFactory query;
    @PostConstruct
    private void initJpaQueryFactory(){
        query = new JPAQueryFactory(entityManager);
    }

}
