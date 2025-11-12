package com.pangci.user.server.controller;

import com.pangci.commom.ResultMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManageController {

    @Value("${test.value}")
    private String data;

    @RequestMapping("/getUser")
    public ResultMessage getUser(){
        ResultMessage resultMessage = new ResultMessage(200,"hello",data);
        return resultMessage;
    }
}
