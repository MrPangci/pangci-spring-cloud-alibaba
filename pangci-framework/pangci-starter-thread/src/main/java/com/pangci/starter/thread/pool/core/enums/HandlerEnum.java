package com.pangci.starter.thread.pool.core.enums;

/**
 * 线程池拒绝策略枚举
 *
 * @author MrPangci
 */
public enum HandlerEnum {

    /**
     * 默认拒绝策略
     */
    ABORT,
    /**
     * 提交任务的主线程自己去执行该任务
     */
    CALLER_RUNS,
    /**
     * 丢弃最老的任务，其实就是把最早进入工作队列的任务丢弃，然后把新任务加入到工作队列
     */
    DISCARD_OLDEST,
    /**
     * 直接丢弃任务，没有任何异常抛出
     */
    DISCARD
}
