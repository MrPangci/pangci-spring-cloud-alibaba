package com.pangci.user.server.mapper;

import com.pangci.user.api.user.dto.UserInfoRespDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoApiMapper {
    /**
     * 获取用户基础信息
     * @param userId
     * @return
     */
    UserInfoRespDTO getUserBaseInfo(int userId);
}
