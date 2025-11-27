package com.pangci.starter.mybatis.core.incrementer;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.pangci.commom.utils.UUIDUtils;

public class UUIDV7IdentifierGenerator implements IdentifierGenerator {
    @Override
    public Number nextId(Object entity) {
        return null;
    }

    @Override
    public String nextUUID(Object entity) {
        return UUIDUtils.getDataKeyUUIDV7();
    }
}
