package com.nano.msc.evaluation.enums;

import lombok.Getter;

/**
 * @author luoxin
 * Description:
 * UDP类仪器以3开头
 * TCP类仪器以4开头
 * 串口类仪器以5开头
 */
@Getter
public enum DeviceCodeEnum {

    //------------------------------------------------------
    // UDP类仪器
    //------------------------------------------------------

    /**
     * 合肥诺和NW9002S
     */
    NORWAMD_9002S(30),

    /**
     * 浙江普可YY-106
     */
    PEARLCARE_YY106(31),

    /**
     * 广东宝莱特 A8
     */
    BAO_LAI_TE(32),

    /**
     * 宜安
     */
    YI_AN_8700_A(33),

    //------------------------------------------------------
    // TCP类仪器
    //------------------------------------------------------
    /**
     * 迈瑞 BeneView T8
     */
    MAI_RUI_T8(42),

    /**
     * 迈瑞 WATOEX 65
     */
    MAI_RUI_WATOEX_65(43),

    /**
     * 迈瑞WATOEX55 PRO
     */
    MAI_RUI_WATOEX_55_PRO(44),

    /**
     * 理邦 ELite V8
     */
    LI_BANG_ELITE_V8(45),


    //------------------------------------------------------
    // 串口类仪器
    //------------------------------------------------------

    /**
     * 苏州爱琴
     */
    AI_QIN_EGOS600A(50),

    /**
     * 重庆名希
     */
    MING_XI(51),

    /**
     * 美敦力 麻醉深度
     */
    MEIDUNLI_VISTA(52),

    /**
     * 美敦力 血红蛋白
     */
    MEIDUNLI_5100C(53),
    ;

    /**
     * 仪器号
     */
    private Integer code;


    DeviceCodeEnum(Integer code) {
        this.code = code;
    }


    /**
     * 传入仪器号得到相应的枚举
     *
     * @param code 仪器号
     * @return 对应的枚举
     */
    public static DeviceCodeEnum matchDeviceCodeEnum(Integer code) {
        for (DeviceCodeEnum deviceCodeEnum : DeviceCodeEnum.values()) {
            if (deviceCodeEnum.getCode().equals(code)) {
                return deviceCodeEnum;
            }
        }
        return null;
    }

    /**
     * 传入仪器号得到相应的枚举
     *
     * @param code 仪器号
     * @return 对应的枚举
     */
    public static DeviceCodeEnum matchDeviceCodeEnum(String code) {
        for (DeviceCodeEnum deviceCodeEnum : DeviceCodeEnum.values()) {
            if (deviceCodeEnum.getCode().equals(Integer.parseInt(code))) {
                return deviceCodeEnum;
            }
        }
        return null;
    }


}
