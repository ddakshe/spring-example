package com.example.spring.domain;

import com.example.spring.config.TestDataSourceConfig;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(TestDataSourceConfig.class)
@AutoConfigureTestDatabase(replace = Replace.NONE) // 스키마 사용을 위해
public class BaseTests {

}
