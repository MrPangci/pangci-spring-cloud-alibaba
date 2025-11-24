package com.pangci.user.server.service.impl;

import com.pangci.user.api.user.dto.UserInfoRespDTO;
import com.pangci.user.server.mapper.UserInfoApiMapper;
import com.pangci.user.server.service.UserInfoApiIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoApiServiceImpl implements UserInfoApiIService {

    @Autowired
    UserInfoApiMapper userInfoApiMapper;

    @Override
    public UserInfoRespDTO getUserBaseInfo(int userId) {
        return userInfoApiMapper.getUserBaseInfo(userId);
    }
}
