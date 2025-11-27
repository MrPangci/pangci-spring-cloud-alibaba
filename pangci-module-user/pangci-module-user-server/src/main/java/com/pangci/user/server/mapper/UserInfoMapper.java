package com.pangci.user.server.mapper;

import com.pangci.starter.mybatis.core.mapper.BaseMapperX;
import com.pangci.user.api.user.dto.UserInfoRespDTO;
import com.pangci.user.server.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface UserInfoMapper extends BaseMapperX<UserInfo> {
    /**
     * 获取用户基础信息
     * @param userId
     * @return
     */
    @Cacheable(cacheNames = "userInfo", key = "#userId")
    UserInfoRespDTO getUserBaseInfo(String userId);
}
