package com.pangci.ai.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.pangci.ai.server",
        "com.pangci.*.api"// 添加外部 fallback 类所在包
})
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.pangci.*.api")
public class PangCiAiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PangCiAiApplication.class, args);
    }
}
