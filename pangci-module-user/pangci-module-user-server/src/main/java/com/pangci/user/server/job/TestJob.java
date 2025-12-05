package com.pangci.user.server.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestJob {

    @XxlJob("testJob")
    public void execute(){
        log.info("测试定时任务执行");
        XxlJobHelper.log("哈哈哈哈哈");
    }
}
