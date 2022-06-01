package com.example.spring.config.database;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.h2.tools.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"h2db", "default"})
public class DevDataSourceConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() throws SQLException {

        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9093").start();
        return DataSourceBuilder.create().build();
    }
}
