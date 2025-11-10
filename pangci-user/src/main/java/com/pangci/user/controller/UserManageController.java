package com.pangci.user.controller;

import com.pangci.common.model.ResultMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManageController {
    @RequestMapping("/getUser")
    public ResultMessage getUser(){
        ResultMessage resultMessage = new ResultMessage(200,"hello");
        return resultMessage;
    }
}
