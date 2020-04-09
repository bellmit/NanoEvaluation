package com.nano.msc.common.vo;

import com.nano.msc.common.enums.RequestCodeEnum;

import lombok.Data;

/**
 * 装在CommonResult中的数据对象
 * @author nano
 * 主要用于数据采集时与平板采集端交互使用
 */
@Data
public class CollectionVo {

    /**
     * 请求代号 根据项目情况自己定义
     */
    private Integer code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    public CollectionVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取网络状态
     *
     * @return 网络状态数据
     */
    public static CollectionVo getNetworkStatus() {
        return new CollectionVo(RequestCodeEnum.SERVER_STATUS.getCode(), RequestCodeEnum.SERVER_STATUS.getMsg(), "");
    }


}
