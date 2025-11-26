package com.pangci.user.server.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@TableName("user_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo {
    @TableId
    private String userId;
    private String userName;
    private String password;
    private String loginName;
    private LocalDateTime createTime;
    private String deptId;
}
