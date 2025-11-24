package com.pangci.user.api.user.fallback;

import com.pangci.commom.pojo.ResultMessage;
import com.pangci.user.api.user.UserInfoApi;
import com.pangci.user.api.user.dto.UserInfoRespDTO;
import org.springframework.stereotype.Component;

@Component
public class UserInfoApiFallback implements UserInfoApi {
    @Override
    public ResultMessage<UserInfoRespDTO> getUserBaseInfo(int userId) {
        return new ResultMessage<>(500,"getUserData不可用，开始服务降级处理",new UserInfoRespDTO());
    }
}
