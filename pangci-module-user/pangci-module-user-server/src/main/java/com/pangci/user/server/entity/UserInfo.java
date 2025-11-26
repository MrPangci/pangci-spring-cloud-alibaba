package com.pangci.user.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("user_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo {
    private String userId;
    private String userName;
    private String password;
    private String loginName;
    private String createTime;
    private String deptId;
}
