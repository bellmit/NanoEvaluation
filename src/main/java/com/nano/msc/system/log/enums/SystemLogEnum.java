package com.nano.msc.system.log.enums;

import lombok.Getter;

/**
 * 系统日志类型枚举
 * @author nano
 */
@Getter
public enum SystemLogEnum {

    /**
     * 调试信息
     */
    DEBUG(0),

    /**
     * 日常信息
     */
    INFO(1),

    /**
     * 错误
     */
    ERROR(-1),

    ;

    private Integer code;

    SystemLogEnum(Integer code) {
        this.code = code;
    }
}
