package com.pangci.user.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.pangci")
@SpringBootApplication
@EnableDiscoveryClient
public class PangCiUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(PangCiUserApplication.class, args);
    }
}
