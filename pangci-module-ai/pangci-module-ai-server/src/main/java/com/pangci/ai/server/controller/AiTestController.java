package com.pangci.ai.server.controller;

import com.pangci.commom.ResultMessage;
import com.pangci.user.api.user.UserDataApi;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiTestController {

    @Resource
    private UserDataApi userDataApi;

    @RequestMapping("/aiTest")
    public ResultMessage aiTest(){
        return userDataApi.getUserData("2345");
    }
}
