package com.nano.msc.common.vo;



import com.nano.msc.common.enums.ResponseEnum;
import com.nano.msc.common.exceptions.CrudException;
import com.nano.msc.common.exceptions.ParseException;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.Objects;

/**
 * 主要用于方法返回信息，Service层往Controller层传输的对象
 *
 * @author luoxin
 */
public class ResultDTO implements Serializable {

    private static final long serialVersionUID = -2927490301829187712L;

    /**
     * 返回处理结果
     *
     * @see ResponseEnum
     */
    private Integer status;

    /**
     * 返回具体错误信息，主要是提示使用该接口的用户具体错误
     */
    private Object msg;

    /**
     * 返回的数据，查询数据等
     */
    private Object data;

    /**
     * 成功
     */
    public static ResultDTO success() {
        return new ResultDTO(ResponseEnum.SUCCESS);
    }

    public static ResultDTO success(Object data) {
        return new ResultDTO(ResponseEnum.SUCCESS, data);
    }

    public static ResultDTO unknownDataType() {
        return new ResultDTO(ResponseEnum.UNKNOWN_DATA_TYPE);
    }

    public static ResultDTO unknownError(Object data) {
        return new ResultDTO(ResponseEnum.UNKNOWN_ERROR, data);
    }

    public static ResultDTO unknownError(String msg, Object data) {
        return new ResultDTO(ResponseEnum.UNKNOWN_ERROR.getStatus(), msg, data);
    }

    public static ResultDTO noLeadingData(Object data) {
        return new ResultDTO(ResponseEnum.NO_LEADING_DATA, data);
    }

    public static ResultDTO noLeadingData(String msg, Object data) {
        return new ResultDTO(ResponseEnum.NO_LEADING_DATA.getStatus(), msg, data);
    }

    /**
     * 构造器方法
     *
     * @return 构造器对象
     */
    private static Builder dataFormatErrorBuilder() {
        return new Builder()
                .status(ResponseEnum.DATA_FORMAT_ERROR.getStatus())
                .msg(ResponseEnum.DATA_FORMAT_ERROR.getMsg());
    }

    /**
     * 构造器模式
     *
     * @param data 数据
     * @return 返回构造器
     */
    private static Builder dataFormatErrorBuilder(Object data) {
        return dataFormatErrorBuilder().data(data);
    }

    public static ResultDTO dataFormatError() {
        return new ResultDTO(ResponseEnum.DATA_FORMAT_ERROR);
    }

    public static ResultDTO dataFormatError(Object data) {
        return dataFormatErrorBuilder().data(data).build();
    }

    public static ResultDTO dataFormatError(String msg, Object data) {
        return dataFormatErrorBuilder(data).msg(msg).build();
    }

    /**
     * 数据格式错误
     */
    public static ResultDTO dataFormatError(Throwable throwable, Object data) {
        Builder builder = dataFormatErrorBuilder(data);
        if (throwable instanceof ParseException) {
            builder.msg(((ParseException) throwable).getErrorMsg());
        } else if (throwable instanceof CrudException) {
            builder.msg(((CrudException) throwable).getErrorMsg());
        } else {
            builder.msg(throwable.getCause());
        }
        return builder.build();
    }

    public static ResultDTO dataFormatError(ParseException exception, Object data) {
        return dataFormatErrorBuilder(data).msg(exception.getErrorMsg()).build();
    }

    public static ResultDTO dataFormatError(RuntimeException exception, Object data) {
        return dataFormatErrorBuilder(data).msg(exception.getCause()).build();
    }

    public static ResultDTO dataExisted(Object data) {
        return new ResultDTO(ResponseEnum.DATA_EXISTED, data);
    }

    /**
     * 数据不存在
     */
    public static ResultDTO dataNotExist() {
        return new ResultDTO(ResponseEnum.DATA_NOT_EXIST);
    }

    public static ResultDTO checkAndReturn(Object o) {
        return Objects.isNull(o) ? dataNotExist() : success(o);
    }


    public static ResultDTO convertAndReturn(CrudException e) {
        return new ResultDTO(e.getStatus(), e.getCause().toString(), e.getErrorData());
    }

    public static <T> ResultDTO checkAndReturn(Page<T> tPage) {
        return tPage.getContent().size() == 0 ? dataNotExist() : success(tPage.getContent());
    }

    private ResultDTO() {
        this(null, null, null);
    }

    private ResultDTO(Integer status, Object msg) {
        this(status, msg, null);
    }

    private ResultDTO(Integer status, Object msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ResultDTO(ResponseEnum responseEnum) {
        this(responseEnum.getStatus(), responseEnum.getMsg(), null);
    }

    private ResultDTO(ResponseEnum responseEnum, Object data) {
        this(responseEnum.getStatus(), responseEnum.getMsg(), data);
    }

    public ResultDTO(Builder builder) {
        this.status = builder.status;
        this.msg = builder.msg;
        this.data = builder.data;
    }


    /**
     * 构造类
     */
    private static class Builder {
        private Integer status;
        private Object msg;
        private Object data;

        private Builder status(Integer status) {
            this.status = status;
            return this;
        }

        private Builder msg(Object msg) {
            this.msg = msg;
            return this;
        }

        private Builder data(Object data) {
            this.data = data;
            return this;
        }

        public ResultDTO build() {
            return new ResultDTO(this);
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code=" + status +
                ", msg=" + msg +
                ", data=" + data +
                '}';
    }
}