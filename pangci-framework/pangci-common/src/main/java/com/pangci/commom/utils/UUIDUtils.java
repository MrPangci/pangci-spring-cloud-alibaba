package com.pangci.commom.utils;

import com.github.f4b6a3.uuid.alt.GUID;

public class UUIDUtils {

    /**
     * 获取UUIDV7版本的数据库主键
     */
    public static String getDataKeyUUIDV7() {
        GUID guid = GUID.v7();
        return guid.toString().replaceAll("-", "");
    }
}
