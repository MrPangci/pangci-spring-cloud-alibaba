package com.pangci.starter.thread.pool.core;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

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

    // 受管理的关闭方法，只有特定权限才能调用
    public void managedShutdown() {
        this.shutdownRequested = true;
        super.shutdown();
    }

    public void managedShutdownNow() {
        this.shutdownRequested = true;
        super.shutdownNow();
    }

    @Override
    public void execute(Runnable command) {
        if (shutdownRequested) {
            throw new RejectedExecutionException("线程池已关闭");
        }
        super.execute(command);
    }
}
