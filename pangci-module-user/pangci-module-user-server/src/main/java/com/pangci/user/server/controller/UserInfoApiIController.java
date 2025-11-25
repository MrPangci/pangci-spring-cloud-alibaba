package com.pangci.user.server.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pangci.commom.pojo.ResultMessage;
import com.pangci.user.api.user.UserInfoApi;
import com.pangci.user.api.user.dto.UserInfoRespDTO;
import com.pangci.user.server.service.UserInfoApiIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static com.pangci.commom.exception.enums.GlobalErrorCodeConstants.TOO_MANY_REQUESTS;

@RestController
@Validated
public class UserInfoApiIController implements UserInfoApi {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    UserInfoApiIService userInfoApiIService;

    @Override
    @SentinelResource( value = "getUserBaseInfoSentinel", blockHandler = "getUserBaseInfoSentinelBlockHandler")
    public ResultMessage<UserInfoRespDTO> getUserBaseInfo(int userId) {
        redisTemplate.opsForValue().set("userId",userId, 60, TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("userId"));
        return ResultMessage.success(userInfoApiIService.getUserBaseInfo(userId));
    }

    /**
     * Sentinel限流降级处理
     * @param userId
     * @param e
     * @return
     */
    public ResultMessage<UserInfoRespDTO> getUserBaseInfoSentinelBlockHandler(int userId, BlockException  e){
        return ResultMessage.error(TOO_MANY_REQUESTS);
    }
}
