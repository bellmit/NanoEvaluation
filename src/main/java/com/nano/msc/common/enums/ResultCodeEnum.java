package com.nano.msc.common.enums;

import com.nano.msc.common.vo.IErrorCode;

/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum ResultCodeEnum implements IErrorCode {

    /**
     * 成功
     */
    SUCCESS(200, "SUCCESS"),

    /**
     * 失败
     */
    FAILED(500, "ERROR"),

    /**
     * 参数校验失败
     */
    VALIDATE_FAILED(404, "VALIDATE_FAILED"),

    /**
     * 未认证
     */
    UNAUTHORIZED(401, "You need login or token is invalid."),

    /**
     * 无权限
     */
    FORBIDDEN(403, "FORBIDDEN")
    ;

    /**
     * 代号
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
