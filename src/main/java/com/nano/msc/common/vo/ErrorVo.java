package com.nano.msc.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 错误VO对象
 * @author nano
 */
@Data
@AllArgsConstructor
public class ErrorVo {

    /**
     * 错误码枚举
     */
    private ErrorCodeEnum errorCodeEnum;

    /**
     * 错误数据
     */
    private String errorData;
}
