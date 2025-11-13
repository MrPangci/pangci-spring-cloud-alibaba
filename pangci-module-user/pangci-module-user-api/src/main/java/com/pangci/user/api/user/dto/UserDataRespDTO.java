package com.pangci.user.api.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "RPC 服务 - 用户数据 Response DTO")
@Data
public class UserDataRespDTO {
    @Schema(description = "用户姓名", required = true,example = "李佳萌")
    private String userName;
}
