package com.nano.msc.common.enums;

import lombok.Getter;

/**
 * 请求码的枚举
 * @author nano
 * 根据项目情况来自定义
 */
@Getter
public enum RequestCodeEnum {

    /**
     * 服务器是否在线请求
     */
    SERVER_STATUS(101, "服务器在线"),

    /**
     * 上传手术信息
     */
    COLLECTION_OPERATION_INFO(103, "收到手术信息"),

    /**
     * 开始手术采集数据
     */
    COLLECTION_START_OPERATION(105, "开始采集数据"),

    /**
     * 仪器数据
     */
    COLLECTION_DEVICE_DATA(107, "Device Data"),

    /**
     * 标记数据
     */
    COLLECTION_OPERATION_MARK(109, "收到手术标记数据"),

    /**
     * 停止手术采集数据
     */
    COLLECTION_STOP_OPERATION(111, "停止采集数据"),

    /**
     * 术后仪器评价信息
     */
    COLLECTION_DEVICE_EVALUATION(113, "收到术后仪器评价数据"),
    ;

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    RequestCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
