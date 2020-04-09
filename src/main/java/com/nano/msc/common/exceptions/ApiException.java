package com.nano.msc.common.exceptions;


import com.nano.msc.common.vo.ErrorVo;
import com.nano.msc.common.vo.IErrorCode;

import lombok.Data;

/**
 * 自定义API异常
 * Created by macro on 2020/2/27.
 */
@Data
public class ApiException extends RuntimeException {


    private IErrorCode errorCode;

    private ErrorVo errorVo;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


    public ApiException(ErrorVo errorVo) {
        this.errorVo = errorVo;
    }


    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
