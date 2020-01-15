package com.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * User: Kyll
 * Date: 2018-10-09 08:38
 */
@Configuration
public class DataSourceConfig {
    @ConfigurationProperties(prefix = "spring.datasource.gfdev")
    @Bean
    public DataSource gfdevDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @ConfigurationProperties(prefix = "spring.datasource.gffldev")
    @Bean
    public DataSource gffldevDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
