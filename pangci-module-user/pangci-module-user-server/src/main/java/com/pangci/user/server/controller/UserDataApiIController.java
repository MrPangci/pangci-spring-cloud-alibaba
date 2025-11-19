package com.pangci.user.server.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pangci.commom.ResultMessage;
import com.pangci.user.api.user.UserDataApi;
import com.pangci.user.api.user.dto.UserDataRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Validated
public class UserDataApiIController implements UserDataApi {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Override
    @SentinelResource( value = "getUserDataSentinel", blockHandler = "getUserDataSentinel")
    public ResultMessage<UserDataRespDTO> getUserData(String userId) {
        UserDataRespDTO userDataRespDTO = new UserDataRespDTO();
        userDataRespDTO.setUserName("张三"+userId);
        redisTemplate.opsForValue().set("userId",userId, 10, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("userId"));
        return new ResultMessage<>(200,"成功",userDataRespDTO);
    }

    /**
     * Sentinel限流降级处理
     * @param userId
     * @param e
     * @return
     */
    public ResultMessage<UserDataRespDTO> getUserDataSentinel(String userId, BlockException  e){
        return new ResultMessage<>(500,"getUserDataSentinel不可用{}"+e.getMessage(),new UserDataRespDTO());
    }
}
