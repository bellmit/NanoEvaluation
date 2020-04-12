package com.nano.msc.common.vo;

import com.nano.msc.common.enums.CollectCodeEnum;
import com.nano.msc.common.enums.ExceptionEnum;

import lombok.Data;

/**
 * 装在CommonResult中的数据对象
 * @author nano
 * 主要用于数据采集时与平板采集端交互使用
 */
@Data
public class CollectionVo<T> {


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
    private T data;

    private CollectionVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    /**
     * 返回出错信息
     *
     * @param exceptionEnum 请求时的出错信息
     */
    public static CollectionVo error(ExceptionEnum exceptionEnum) {
        return new CollectionVo<>(exceptionEnum.getErrorCode(), exceptionEnum.getMessage(), "");
    }


    /**
     * 返回出错信息
     *
     * @param exceptionEnum 请求时的出错信息
     */
    public static CollectionVo error(ExceptionEnum exceptionEnum, String msg) {
        return new CollectionVo<>(exceptionEnum.getErrorCode(), exceptionEnum.getMessage(), msg);
    }


    /**
     * 获取网络状态
     *
     * @return 网络状态数据
     */
    public static CollectionVo<String> responseServerStatus() {
        return new CollectionVo<>(CollectCodeEnum.RESPONSE_SERVER_STATUS.getCode(),
                CollectCodeEnum.SERVER_STATUS.getMsg(), "");
    }


    /**
     * 回复手术场次号
     *
     * @param operationNumber 手术场次号
     * @return VO
     */
    public static CollectionVo<Integer> responseOperationInfo(Integer operationNumber) {
        return new CollectionVo<>(CollectCodeEnum.RESPONSE_COLLECTION_OPERATION_INFO.getCode(),
                CollectCodeEnum.RESPONSE_COLLECTION_OPERATION_INFO.getMsg(), operationNumber);
    }


    /**
     * 回复收到开始信息
     */
    public static CollectionVo responseStartOperation() {
        return new CollectionVo<>(CollectCodeEnum.RESPONSE_COLLECTION_START_OPERATION.getCode(),
                CollectCodeEnum.RESPONSE_COLLECTION_START_OPERATION.getMsg(), "");
    }

    /**
     * 回复收到仪器数据
     */
    public static CollectionVo responseDeviceData() {
        return new CollectionVo<>(CollectCodeEnum.RESPONSE_COLLECTION_DEVICE_DATA.getCode(),
                CollectCodeEnum.RESPONSE_COLLECTION_DEVICE_DATA.getMsg(), "");
    }

    /**
     * 回复收到标记信息
     */
    public static CollectionVo responseMarkInfo() {
        return new CollectionVo<>(CollectCodeEnum.RESPONSE_COLLECTION_OPERATION_MARK.getCode(),
                CollectCodeEnum.RESPONSE_COLLECTION_OPERATION_MARK.getMsg(), "");
    }

    /**
     * 回复收到结束采集
     */
    public static CollectionVo responseStopOperation() {
        return new CollectionVo<>(CollectCodeEnum.RESPONSE_COLLECTION_STOP_OPERATION.getCode(),
                CollectCodeEnum.RESPONSE_COLLECTION_STOP_OPERATION.getMsg(), "");
    }


    /**
     * 回复收到术后仪器评价信息
     */
    public static CollectionVo responseDeviceEvaluation() {
        return new CollectionVo<>(CollectCodeEnum.RESPONSE_COLLECTION_DEVICE_EVALUATION.getCode(),
                CollectCodeEnum.RESPONSE_COLLECTION_DEVICE_EVALUATION.getMsg(), "");
    }
}
