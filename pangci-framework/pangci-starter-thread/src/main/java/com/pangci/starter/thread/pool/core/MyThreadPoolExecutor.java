package com.pangci.starter.thread.pool.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class MyThreadPoolExecutor extends ThreadPoolExecutor implements DisposableBean, ApplicationListener<ContextClosedEvent> {

    private volatile boolean shutdownRequested = false;

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    public void shutdown() {
        // 忽略关闭请求，或者记录日志
        log.warn("直接调用shutdown()被阻止，请使用managedShutdown()方法");
    }

    @Override
    public List<Runnable> shutdownNow() {
        log.warn("直接调用shutdownNow()被阻止，请使用managedShutdown()方法");
        return Collections.emptyList();
    }

    /**
     * 优雅关闭
     */
    public void gracefulShutdown() {
        this.shutdownRequested = true;
        super.shutdown();
        try {
            // 等待任务完成
            if (!awaitTermination(60, TimeUnit.SECONDS)) {
                log.warn("优雅关闭超时，尝试强制关闭");
                super.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("关闭过程被中断", e);
            Thread.currentThread().interrupt();
            super.shutdownNow();
        }
    }

    @Override
    public void execute(Runnable command) {
        if (shutdownRequested) {
            throw new RejectedExecutionException("线程池已关闭，无法执行新任务");
        }
        super.execute(command);
    }

    /**
     * Spring容器销毁时的回调
     */
    @Override
    public void destroy() throws Exception {
        log.info("Spring容器关闭，开始关闭线程池...");
        this.shutdownRequested = true;
        gracefulShutdown();
        log.info("线程池已关闭");
    }

    /**
     * 监听容器关闭事件，作为备用关闭机制
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        if (!isShutdown()) {
            log.info("收到容器关闭事件，关闭线程池...");
            this.shutdownRequested = true;
            gracefulShutdown();
        }
    }
}
