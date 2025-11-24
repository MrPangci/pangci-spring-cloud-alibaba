package com.pangci.user.server.controller;

import com.pangci.commom.pojo.ResultMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManageController {

    @RequestMapping("/getUser/{userId}")
    public ResultMessage getUser(@RequestParam("userId") String userId){
        ResultMessage resultMessage = new ResultMessage(200,"hello",userId);
        return resultMessage;
    }
}
