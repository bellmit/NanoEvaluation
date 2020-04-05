package com.nano.msc.common.vo;




import com.nano.msc.common.enums.ResponseEnum;
import com.nano.msc.common.exceptions.CrudException;
import com.nano.msc.common.exceptions.ParseException;

import java.io.Serializable;
import java.util.Objects;

/**
 * 对外层返回对象，返回用户信息
 *
 * @author lx
 * @version V1.0
 * @date 2019/6/13 11:14
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ResultVO implements Serializable {

    private static final long serialVersionUID = -6307758086932966263L;

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
     * 请求的类型，根据项目定义
     * <p>由于请求可能采用异步方式，这里定义<code>type</code></p>
     * <p>如果请求采用同步方式，可以忽略该字段</p>
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

    public static ResultVO checkAndReturn(ParseException e) {
        return new ResultVO(e.getStatus(), e.getErrorMsg(), -1, e.getErrorData());
    }

    public static ResultVO checkAndReturn(CrudException e) {
        return new ResultVO(e.getStatus(), e.getErrorMsg(), -1, e.getErrorData());
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

    private static ResultVO unknownError(Integer type) {
        return new ResultVO(-1, "未知错误", type + 1, "");
    }

    /**
     * 检查并返回
     *
     * @param resultDTO ResultDTO
     * @param type      接口类型
     * @return ResultVO
     */
    public static ResultVO checkAndReturn(ResultDTO resultDTO, Integer type) {
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
        if (Objects.isNull(resultDTO)) {
            return unknownError(-1);
        }
        return new ResultVO(resultDTO.getStatus(), resultDTO.getMsg(), -1, resultDTO.getData());
    }

    @Deprecated
    public static ResultVO checkAndReturn(Object object, Integer type) {
        return new ResultVO(200, "ok", type, object);
    }
}
