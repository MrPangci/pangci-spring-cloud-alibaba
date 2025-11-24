package com.pangci.user.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    /*@Bean
    @ConfigurationProperties("spring.datasource.dynamic.datasource.master")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.dynamic.datasource.slave")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }*/
}
