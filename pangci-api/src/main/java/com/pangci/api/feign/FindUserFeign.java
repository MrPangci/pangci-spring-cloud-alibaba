package com.pangci.api.feign;

import com.pangci.commom.core.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "pangci-user")
public interface FindUserFeign {
    @GetMapping("/getUser")
    public ResultMessage getUser();
}
