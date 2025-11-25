package com.pangci.user.server.controller;

import com.pangci.commom.model.ResultMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManageController {

    @RequestMapping("/getUser/{userId}")
    public ResultMessage getUser(@RequestParam("userId") String userId){
        ResultMessage resultMessage = new ResultMessage();
        return resultMessage;
    }
}
