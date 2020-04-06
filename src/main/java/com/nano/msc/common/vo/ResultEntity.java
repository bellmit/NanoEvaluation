package com.nano.msc.common.vo;

import com.nano.msc.common.enums.StatusEnum;

import java.io.Serializable;

import lombok.Data;

/**
 * 消息返回实体
 * @author nano
 */
@Data
public class ResultEntity implements Serializable {

    private static final long serialVersionUID = -2927490301829487112L;

    /**
     * 请求结果的状态 类似于标准HTTP相应码 可以根据具体的业务定义失败码
     *
     * @see StatusEnum
     */
    private Integer status;

    /**
     * 返回具体错误信息，主要是提示使用该接口的用户具体错误
     */
    private String msg;

    /**
     * 请求的类型，根据项目定义不同的类型码
     *
     * <p>由于请求可能采用异步方式，这里定义<code>type</code></p>
     * <p>如果请求采用同步方式，可以忽略该字段</p>
     * <p>比如登录type是101，登录成功返回102</p>
     */
    private Integer code;

    /**
     * 返回的数据，查询数据等
     */
    private Object data;


    private ResultEntity(Integer status, String msg, Integer code, Object data) {
        this.status = status;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}
