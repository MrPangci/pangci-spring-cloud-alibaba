package com.pangci.api.controller;

import com.pangci.api.feign.FindUserFeign;
import com.pangci.commom.core.ResultMessage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {

    @Resource
    private FindUserFeign findUserFeign;

    @RequestMapping("/hello")
    public ResultMessage hello(){
        ResultMessage resultMessage = findUserFeign.getUser();
        return resultMessage;
    }
}
