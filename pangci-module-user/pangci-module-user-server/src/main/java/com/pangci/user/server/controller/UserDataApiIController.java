package com.pangci.user.server.controller;

import com.pangci.commom.ResultMessage;
import com.pangci.user.api.user.UserDataApi;
import com.pangci.user.api.user.dto.UserDataRespDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserDataApiIController implements UserDataApi {
    @Override
    public ResultMessage<UserDataRespDTO> getUserData(String userId) {
        UserDataRespDTO userDataRespDTO = new UserDataRespDTO();
        userDataRespDTO.setUserName("张三"+userId);
        return new ResultMessage<>(200,"成功",userDataRespDTO);
    }
}
