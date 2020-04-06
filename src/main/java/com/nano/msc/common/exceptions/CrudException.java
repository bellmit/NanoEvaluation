package com.nano.msc.common.exceptions;



import com.nano.msc.common.constants.DataConstants;
import com.nano.msc.common.enums.CrudTypeEnum;
import com.nano.msc.common.enums.StatusEnum;
import com.nano.msc.common.vo.ResultDTO;

import java.io.Serializable;

import javax.validation.ValidationException;

/**
 * 自定义数据库操作异常
 *
 * @author lx
 * @version V1.0
 * @date 2019/7/25 23:01
 * Description:
 */
public class CrudException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -1343312269172404301L;

    private String msg;
    private Integer status;
    private String errorMsg;
    private String errorData;
    private CrudTypeEnum crudTypeEnum;


    /**
     * 抛出数据已经存在的异常
     */
    public static void dataIsExisted() {
        throw new CrudException(CrudTypeEnum.NON, StatusEnum.DATA_EXISTED);
    }

    /**
     * 抛出数据不存在的异常
     */
    public static void dataIsNotExisted() {
        throw new CrudException(CrudTypeEnum.NON, StatusEnum.DATA_NOT_EXIST);
    }

    public static void saveDataFormatException(String saveObjectMessage) {
        throw new CrudException(CrudTypeEnum.SAVE, StatusEnum.DATA_FORMAT_ERROR, DataConstants.SAVE_ERROR, saveObjectMessage);
    }

    public static void saveDataFormatException(ValidationException e, Object object) {
        throw new CrudException(CrudTypeEnum.SAVE, StatusEnum.DATA_FORMAT_ERROR, e.toString(), object.toString());
    }

    public static void saveUnknownException(Exception e, Object object) {
        throw new CrudException(CrudTypeEnum.SAVE, StatusEnum.UNKNOWN_ERROR, e.toString(), object.toString());
    }

    public static void updateUnknownException(Exception e, Object object) {
        throw new CrudException(CrudTypeEnum.UPDATE, StatusEnum.UNKNOWN_ERROR, e.toString(), object.toString());
    }

    public static void updateIdException() {
        throw new CrudException(CrudTypeEnum.UPDATE, StatusEnum.UPDATE_ID_ERROR);
    }

    public static void deleteUnknownException(Exception e, Object object) {
        throw new CrudException(CrudTypeEnum.DELETE, StatusEnum.UNKNOWN_ERROR, e.toString(), object.toString());
    }

    /**
     * 构造器方式构造Exception对象
     */
    public CrudException(Builder builder) {
        this.status = builder.status;
        this.msg = builder.msg;
        this.errorMsg = builder.errorMsg;
        this.errorData = builder.errorData;
        this.crudTypeEnum = builder.crudTypeEnum;
    }

    /**
     * 构造器
     */
    private static class Builder {
        private String msg;
        private Integer status;
        private String errorMsg;
        private String errorData;
        private CrudTypeEnum crudTypeEnum;

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

        private Builder crudTypeEnum(CrudTypeEnum crudTypeEnum) {
            this.crudTypeEnum = crudTypeEnum;
            return this;
        }

        private CrudException build() {
            return new CrudException(this);
        }
    }

    public CrudException(ResultDTO resultDTO) {
        super();
        this.crudTypeEnum = CrudTypeEnum.NON;
        this.errorMsg = (String) resultDTO.getMsg();
        this.status = resultDTO.getStatus();
        this.errorData = (String) resultDTO.getData();
    }

    private CrudException(CrudTypeEnum crudTypeEnum, StatusEnum statusEnum) {
        super();
        this.crudTypeEnum = crudTypeEnum;
        this.msg = statusEnum.getMsg();
        this.status = statusEnum.getStatus();
    }

    private CrudException(CrudTypeEnum crudTypeEnum, StatusEnum statusEnum, String errorMsg, String errorData) {
        super();
        this.crudTypeEnum = crudTypeEnum;
        this.msg = statusEnum.getMsg();
        this.status = statusEnum.getStatus();
        this.errorMsg = errorMsg;
        this.errorData = errorData;
    }

    private CrudException(CrudTypeEnum crudTypeEnum, String msg, int status, String errorMsg, String errorData) {
        super();
        this.crudTypeEnum = crudTypeEnum;
        this.msg = msg;
        this.status = status;
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

    public CrudTypeEnum getCrudTypeEnum() {
        return crudTypeEnum;
    }

    public void setCrudTypeEnum(CrudTypeEnum crudTypeEnum) {
        this.crudTypeEnum = crudTypeEnum;
    }
}
