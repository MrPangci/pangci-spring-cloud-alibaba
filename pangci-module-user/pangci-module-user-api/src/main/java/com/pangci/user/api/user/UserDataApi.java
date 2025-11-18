package com.pangci.user.api.user;

import com.pangci.commom.ResultMessage;
import com.pangci.user.api.user.dto.UserDataRespDTO;
import com.pangci.user.api.user.fallback.UserDataApiFallback;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "pangci-user" , fallback = UserDataApiFallback.class)
@Tag(name = "用户数据接口")
public interface UserDataApi {

    @RequestMapping("/getUserData")
    @Operation(summary = "获取用户数据")
    @Parameters({
            @Parameter(name = "userId",description = "用户ID",example = "1111",required = true)
    })
    ResultMessage<UserDataRespDTO> getUserData(@RequestParam("userId") String userId);
}
