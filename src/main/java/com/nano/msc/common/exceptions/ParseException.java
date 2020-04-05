package com.nano.msc.common.exceptions;




import com.nano.msc.common.enums.ResponseEnum;

import java.io.Serializable;

/**
 * 自定义数据解析异常
 *
 * @author lx
 * @version V1.0
 * @date 2019/1/25 0:53
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ParseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -2571255590264635858L;

    /**
     * 信息
     */
    private String msg;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 错误的数据
     */
    private String errorData;

    public static void unknownError(Exception e, String json) {
        throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR, e.getCause().toString(), json);
    }

    private static Builder dataFormatExceptionBuilder() {
        return new Builder()
                .status(ResponseEnum.DATA_FORMAT_ERROR.getStatus())
                .msg(ResponseEnum.DATA_FORMAT_ERROR.getMsg());
    }

    /**
     * 构造器模式
     *
     * @param errorData 错误数据
     * @return 构造器
     */
    private static Builder dataFormatExceptionBuilder(Object errorData) {
        return dataFormatExceptionBuilder().errorData(errorData.toString());
    }

    public static void dataFormatException(Object e, Object errorData) {
        throw dataFormatExceptionBuilder(errorData).errorMsg(e.toString()).build();
    }

    public static void dataFormatException(Exception e, Object errorData) {
        throw dataFormatExceptionBuilder(errorData).errorMsg(e.getCause().toString()).build();
    }

    public static void dataFormatException() {
        throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR);
    }

    public static void codeException() {
        throw new ParseException(ResponseEnum.CODE_ERROR);
    }

    public static void dataFormatException(String errorMsg, String errorData) {
        throw new ParseException(ResponseEnum.DATA_FORMAT_ERROR, errorMsg, errorData);
    }

    public ParseException(Builder builder) {
        this.status = builder.status;
        this.msg = builder.msg;
        this.errorMsg = builder.errorMsg;
        this.errorData = builder.errorData;
    }

    private static class Builder {
        private String msg;
        private Integer status;
        private String errorMsg;
        private String errorData;

        private Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        private Builder status(Integer status) {
            this.status = status;
            return this;
        }

        private Builder errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        private Builder errorData(String errorData) {
            this.errorData = errorData;
            return this;
        }

        private ParseException build() {
            return new ParseException(this);
        }
    }

    private ParseException(ResponseEnum responseEnum) {
        super();
        this.msg = responseEnum.getMsg();
        this.status = responseEnum.getStatus();
    }

    private ParseException(String msg, int status, String errorMsg, String errorData) {
        super();
        this.msg = msg;
        this.status = status;
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    private ParseException(ResponseEnum responseEnum, String errorMsg, String errorData) {
        super();
        this.msg = responseEnum.getMsg();
        this.status = responseEnum.getStatus();
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorData() {
        return errorData;
    }

    public void setErrorData(String errorData) {
        this.errorData = errorData;
    }

    @Override
    public String toString() {
        return "ParseException{" +
                "msg='" + msg + '\'' +
                ", status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                ", errorData='" + errorData + '\'' +
                '}';
    }
}
