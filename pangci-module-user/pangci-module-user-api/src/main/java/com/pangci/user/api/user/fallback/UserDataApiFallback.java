package com.pangci.user.api.user.fallback;

import com.pangci.commom.ResultMessage;
import com.pangci.user.api.user.UserDataApi;
import com.pangci.user.api.user.dto.UserDataRespDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDataApiFallback implements UserDataApi {
    @Override
    public ResultMessage<UserDataRespDTO> getUserData(String userId) {
        return new ResultMessage<>(500,"getUserData不可用，开始服务降级处理",new UserDataRespDTO());
    }
}
