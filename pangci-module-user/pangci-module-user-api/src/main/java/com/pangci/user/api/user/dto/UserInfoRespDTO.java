package com.pangci.user.api.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "RPC 服务 - 用户信息 Response DTO")
@Data
public class UserInfoRespDTO {
    @Schema(description = "用户Id", required = true,example = "1")
    private String userId;
    @Schema(description = "用户姓名", required = true,example = "李佳萌")
    private String userName;
    @Schema(description = "用户登录名", required = true,example = "li.jiameng")
    private String loginName;
    @Schema(description = "用户创建时间", required = true,example = "2021-01-01 00:00:00")
    private LocalDateTime createTime;
}
