package com.pangci.starter.thread.pool.config;

import com.pangci.starter.thread.pool.core.enums.HandlerEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@ConfigurationProperties("pangci.thread.pool")
@Data
@Validated
public class ThreadPoolProperties {
    /**
     * 线程池核心线程数
     */
    private int coreSize;
    /**
     * 线程池最大线程数
     */
    private int maxSize;
    /**
     * 线程池线程最大空闲时间
     */
    private Duration keepAliveTime=Duration.ofSeconds(60);
    /**
     * 线程池队列大小
     */
    private int queueSize = 10000;
    /**
     * 线程池拒绝策略
     */
    private HandlerEnum handler = HandlerEnum.ABORT;
}
