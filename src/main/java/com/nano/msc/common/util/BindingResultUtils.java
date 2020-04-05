package com.nano.msc.common.util;


import com.nano.msc.common.vo.ResultDTO;

import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 */
public class BindingResultUtils {

    /**
     * 检测bindingResult是否又错误，如果又错误将抛出ParseException异常
     *
     * @param bindingResult bindingResult
     * @return ResultDTO
     */
    public static ResultDTO checkBindingResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            return ResultDTO.dataFormatError(msg, bindingResult.getTarget());
        }
        return ResultDTO.success();
    }
}
