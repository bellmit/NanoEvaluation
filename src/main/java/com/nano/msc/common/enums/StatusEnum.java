package com.nano.msc.common.enums;

import lombok.Getter;

/**
 * 对所有请求响应的枚举类
 */
@Getter
public enum StatusEnum {

    /**
     * 成功
     */
    SUCCESS(200, "成功");



    /**
     * 状态
     */
    private Integer status;

    /**
     * 消息
     */
    private String msg;

    StatusEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
