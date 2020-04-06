package com.nano.msc.common.vo;




import com.nano.msc.common.enums.StatusEnum;
import com.nano.msc.common.exceptions.CrudException;
import com.nano.msc.common.exceptions.ParseException;

import java.io.Serializable;
import java.util.Objects;

import lombok.Builder;

/**
 * 对外层返回对象，返回用户信息
 * @author nano
 */
public class ResultVO implements Serializable {

    private static final long serialVersionUID = -6307758086932966263L;

    /**
     * 请求结果的状态 类似于标准HTTP相应码 可以根据具体的业务定义失败码
     *
     * @see StatusEnum
     */
    private Integer status;

    /**
     * 返回具体错误信息，主要是提示使用该接口的用户具体错误
     */
    private Object msg;

    /**
     * 请求的类型，根据项目定义不同的类型码
     *
     * <p>由于请求可能采用异步方式，这里定义<code>type</code></p>
     * <p>如果请求采用同步方式，可以忽略该字段</p>
     * <p>比如登录type是101，登录成功返回102</p>
     */
    private Integer type;

    /**
     * 返回的数据，查询数据等
     */
    private Object data;

    private ResultVO() {
        this(null, null, null, null);
    }

    private ResultVO(Integer status, Object msg, Object data) {
        this(status, msg, null, data);
    }

    private ResultVO(Integer status, Object msg, Integer type, Object data) {
        this.status = status;
        this.msg = msg;
        this.type = type;
        this.data = data;
    }

    /**
     * 未知错误
     * @param type 类型Code
     */
    private static ResultVO unknownError(Integer type) {
        return new ResultVO(-1, "未知错误", type + 1, "");
    }

    /**
     * 传入异常并返回
     */
    public static ResultVO checkAndReturn(ParseException e) {
        return new ResultVO(e.getStatus(), e.getErrorMsg(), -1, e.getErrorData());
    }
    public static ResultVO checkAndReturn(CrudException e) {
        return new ResultVO(e.getStatus(), e.getErrorMsg(), -1, e.getErrorData());
    }



    /**
     * 检查实体数据对象并返回
     *
     * @param resultDTO ResultDTO
     * @param type      接口类型
     * @return ResultVO
     */
    public static ResultVO checkAndReturn(ResultDTO resultDTO, Integer type) {
        // 如果传入的DTO为空则返回未知错误
        if (Objects.isNull(resultDTO)) {
            return unknownError(type);
        }
        return new ResultVO(resultDTO.getStatus(), resultDTO.getMsg(), type, resultDTO.getData());
    }

    /**
     * 检查并返回
     *
     * @param resultDTO ResultDTO
     * @return ResultVO
     */
    public static ResultVO checkAndReturn(ResultDTO resultDTO) {
        // 返回默认类型为-1
        return checkAndReturn(resultDTO, -1);
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + status +
                ", msg=" + msg +
                ", type=" + type +
                ", data=" + data +
                '}';
    }


}
