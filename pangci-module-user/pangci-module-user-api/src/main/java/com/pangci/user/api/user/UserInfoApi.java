package com.pangci.user.api.user;

import com.pangci.commom.pojo.ResultMessage;
import com.pangci.user.api.user.dto.UserInfoRespDTO;
import com.pangci.user.api.user.fallback.UserInfoApiFallback;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "pangci-user" , fallback = UserInfoApiFallback.class)
@Tag(name = "用户数据接口")
public interface UserInfoApi {

    @RequestMapping("/getUserBaseInfo/{userId}")
    @Operation(summary = "获取用户数据")
    @Parameters({
            @Parameter(name = "userId",description = "用户ID",example = "1111",required = true)
    })
    ResultMessage<UserInfoRespDTO> getUserBaseInfo(@PathVariable("userId") int userId);
}
