package com.pangci.user.server.service.impl;

import com.pangci.commom.model.PageResult;
import com.pangci.commom.model.SortablePageParam;
import com.pangci.commom.utils.JsonUtils;
import com.pangci.starter.mybatis.core.query.LambdaQueryWrapperX;
import com.pangci.user.server.entity.UserInfo;
import com.pangci.user.server.mapper.UserInfoMapper;
import com.pangci.user.server.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public void testUpdateUser() {
        //测试新增
        UserInfo userInfo = new UserInfo();
        userInfo=userInfo.builder().userName("张三").password("123456").loginName("zhangsan").deptId(1L).build();
        userInfoMapper.insert(userInfo);

        //测试删除
        //userInfoMapper.delete(UserInfo::getId,"0");
        //userInfoMapper.delete(null); //测试删除所有,会被拦截报错

        // 测试分页
        SortablePageParam pageParam = new SortablePageParam();
        //pageParam.setPageNo(1);
        //分页对象也能指定排序列
        /*List<SortingField> sortingFields=new ArrayList<>();
        sortingFields.add(new SortingField("userId", SortingField.ORDER_ASC));
        pageParam.setSortingFields(sortingFields);*/
        LambdaQueryWrapperX<UserInfo> wrapper = new LambdaQueryWrapperX<>();
        wrapper.geIfPresent(UserInfo::getId,28).orderByDesc(UserInfo::getId);//相当于where id=1
        PageResult<UserInfo> userInfoPageResult = userInfoMapper.selectPage(pageParam, wrapper);
        System.out.println(JsonUtils.toJsonString(userInfoPageResult));
    }
}
