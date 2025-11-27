package com.pangci.user.server.service;

import com.pangci.user.api.user.dto.UserInfoRespDTO;

public interface UserInfoApiIService {
    /**
     * 获取用户基本信息
     * @param userId
     * @return
     */
    UserInfoRespDTO getUserBaseInfo(String userId);
}
