package com.example.spring;

import com.example.spring.config.TestDataSourceConfig;
import com.example.spring.domain.Team;
import com.example.spring.domain.User;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@DataJpaTest
@Import(TestDataSourceConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserDataJpaTests {

    @PersistenceContext
    private  EntityManager entityManager;



    @BeforeEach
    void setUp() {
        entityManager.clear();

        Team team = Team.builder().name("개발팀").build();
        entityManager.persist(team);

        User user = User.builder().name("kennen").age(37).team(team).build();
        entityManager.persist(user);

    }

    @Test
    void exist() {
        Team team = entityManager.find(Team.class, 1L);
        Assertions.assertNotNull(team);
        Assertions.assertEquals("개발팀", team.getName());
    }

    @Test
    void testSize() {
        String queryString = "select t  from Team t";
        List<Team> resultList = entityManager.createQuery(queryString, Team.class).getResultList();
        Assertions.assertEquals(resultList.size(), 1);
    }


}

