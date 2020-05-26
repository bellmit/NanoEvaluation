package com.nano.msc.evaluation.enums;

import lombok.Getter;

/**
 * 手术状态枚举类
 * @author nano
 * Description: 枚举状态有无效数据、手术未开始、手术进行中、手术已经结束等状态
 */
@Getter
public enum OperationStateEnum {

    /**
     * 失效状态
     */
    ABANDON(-1, "失效状态"),

    /**
     * 手术还未开始，还在准备中
     */
    PREPARING(0, "手术还未开始，还在准备中"),

    /**
     * 手术进行中
     */
    PROGRESSING(1, "手术进行中"),

    /**
     * 手术已经结束
     */
    FINISHED(2, "手术已经结束"),
    ;


    private Integer code;

    private String msg;

    OperationStateEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static OperationStateEnum matchOperationStateEnum(Integer code) {
        for (OperationStateEnum operationStateEnum : OperationStateEnum.values()) {
            if (operationStateEnum.getCode().equals(code)) {
                return operationStateEnum;
            }
        }
        return null;
    }
}
