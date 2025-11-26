package com.pangci.user.server.controller;

import com.pangci.commom.model.ResultMessage;
import com.pangci.user.server.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @GetMapping("/test")
    public ResultMessage test(){
        userManageService.testUpdateUser();
        return ResultMessage.success("success");
    }
}
