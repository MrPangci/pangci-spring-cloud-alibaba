package com.pangci.starter.mq.rabbit.core.enums;

public enum ExchangeEnum {
    /**
     * 发布订阅模式
     */
    FANOUT,
    /**
     * Routing路由模式
     */
    DIRECT,
    /**
     * Topic主题模式
     */
    TOPICS
}
