package com.nano.msc.common.util;


import com.nano.msc.common.vo.ResultVO;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/11/18
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public class ResultVOUtils {

    public static ResultVO error(Integer code, Object msg) {
        return null;
//        return new ResultVO(code, msg);
    }

    public static ResultVO unknowError() {
        return null;
//        return new ResultVO(StatusEnum.UNKNOWN_ERROR.getCode(), StatusEnum.UNKNOWN_ERROR.getMsg());
    }

    public static ResultVO notFound() {
        return null;
//        return new ResultVO(StatusEnum.DATA_NOT_EXIST.getCode(), StatusEnum.DATA_NOT_EXIST.getMsg());
    }

    public static ResultVO success(Object msg) {
        return null;
//        return new ResultVO(StatusEnum.SUCCESS.getCode(), msg);
    }

    public static ResultVO success() {
        return null;
//        return new ResultVO(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMsg());
    }

    public static ResultVO isExisted(Object msg) {
        return null;
//        return new ResultVO(StatusEnum.DATA_EXISTED.getCode(), msg);
    }

    public static ResultVO checkAndReturn(Object object) {
        return null != object ? success(object) : notFound();
    }
}
