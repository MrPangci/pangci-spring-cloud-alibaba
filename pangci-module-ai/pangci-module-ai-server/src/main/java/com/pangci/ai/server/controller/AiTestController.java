package com.pangci.ai.server.controller;

import com.pangci.commom.model.ResultMessage;
import com.pangci.user.api.user.UserInfoApi;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiTestController {

    @Resource
    private UserInfoApi userInfoApi;

    @RequestMapping("/aiTest")
    public ResultMessage aiTest(){
        return userInfoApi.getUserBaseInfo("222");
    }
}
