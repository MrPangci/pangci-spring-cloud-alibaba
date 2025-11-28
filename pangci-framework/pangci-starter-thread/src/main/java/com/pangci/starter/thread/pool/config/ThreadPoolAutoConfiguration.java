package com.pangci.starter.thread.pool.config;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import com.pangci.starter.thread.pool.core.MyThreadPoolExecutor;
import com.pangci.starter.thread.pool.core.enums.HandlerEnum;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池自动配置类
 *
 * @author MrPangci
 */
@AutoConfiguration
@EnableConfigurationProperties(ThreadPoolProperties.class)
@ConditionalOnProperty(prefix = "pangci.thread.pool", name = "core-size")
public class ThreadPoolAutoConfiguration {

    /**
     * 创建线程池
     */
    @Bean
    public MyThreadPoolExecutor myThreadPoolExecutor(ThreadPoolProperties threadPoolProperties) {
        RejectedExecutionHandler rejectedExecutionHandler = getHandler(threadPoolProperties.getHandler());
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(
                threadPoolProperties.getCoreSize(),
                threadPoolProperties.getMaxSize(),
                threadPoolProperties.getKeepAliveTime().getSeconds(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(threadPoolProperties.getQueueSize()),
                new ThreadFactoryBuilder().build(),
                rejectedExecutionHandler);
        return myThreadPoolExecutor;
    }

    /**
     * 获取拒绝策略
     *
     * @param handler 拒绝策略
     * @return 拒绝策略
     */
    private RejectedExecutionHandler getHandler(HandlerEnum handler) {
        RejectedExecutionHandler rejectedExecutionHandler=null;
        switch (handler) {
            case CALLER_RUNS:
                rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
                break;
            case ABORT:
                rejectedExecutionHandler = new ThreadPoolExecutor.AbortPolicy();
                break;
            case DISCARD:
                rejectedExecutionHandler = new ThreadPoolExecutor.DiscardPolicy();
                break;
            case DISCARD_OLDEST:
                rejectedExecutionHandler = new ThreadPoolExecutor.DiscardOldestPolicy();
                break;
        }
        return rejectedExecutionHandler;
    }
}
