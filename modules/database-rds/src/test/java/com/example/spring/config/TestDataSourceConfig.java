package com.example.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class TestDataSourceConfig {

    // application-h2db.yml 파일 별도로 생성
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource(){ // 테스트 시에는 tcp 로 접근은 필요 없음
        return DataSourceBuilder.create().build(); // DataSource 를 새로 생성하기 때문에 application 실행 중에도 DataJpaTest 가능
    }
}
