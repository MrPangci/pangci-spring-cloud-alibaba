package com.pangci.user.server.controller;

import com.pangci.commom.model.ResultMessage;
import com.pangci.starter.thread.pool.core.MyThreadPoolExecutor;
import com.pangci.user.server.service.UserManageService;
import jakarta.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @Resource
    private MyThreadPoolExecutor myThreadPoolExecutor;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @GetMapping("/test")
    public ResultMessage test(){
        userManageService.testUpdateUser();
        return ResultMessage.success("success");
    }
    @GetMapping("/test2")
    public void test2(){
        for (int i = 0; i < 10; i++){
            myThreadPoolExecutor.execute(() -> {
                Random random = new Random();
                System.out.println("执行异步任务:"+random.nextInt());
            });
        }
    }

    @GetMapping("/test3")
    public void test3(){
        rabbitTemplate.convertAndSend("helloQueue", "Hello World!");
    }

}
