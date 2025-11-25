package com.pangci.user.api.user.fallback;

import com.pangci.commom.pojo.ResultMessage;
import com.pangci.user.api.user.UserInfoApi;
import com.pangci.user.api.user.dto.UserInfoRespDTO;
import org.springframework.stereotype.Component;

import static com.pangci.commom.exception.enums.GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR;

@Component
public class UserInfoApiFallback implements UserInfoApi {
    @Override
    public ResultMessage<UserInfoRespDTO> getUserBaseInfo(int userId) {
        return ResultMessage.error(INTERNAL_SERVER_ERROR);
    }
}
