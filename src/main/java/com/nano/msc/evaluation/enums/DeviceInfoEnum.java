package com.nano.msc.evaluation.enums;

import lombok.Getter;

/**
 * 仪器基本信息枚举
 *
 * @author nano
 * Description:
 * UDP类仪器以3开头
 * TCP类仪器以4开头
 * 串口类仪器以5开头
 *
 * 仪器信息包含自定义的deviceCode
 * 仪器名称
 * 仪器厂家名称
 * 仪器类别：仪器如果涉及多个类别，则进行拼接得到字符串形式
 */
@Getter
public enum DeviceInfoEnum {

    //------------------------------------------------------
    // UDP类仪器
    //------------------------------------------------------

    /**
     * 合肥诺和NW9002S
     */
    NORWAMD_9002S(30, "合肥诺和电子科技有限公司", "麻醉深度多参数监护仪(NW-9002S)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.ANESTHESIA_DEPTH_MONITOR,
                                        DeviceTypeEnum.HEMOGLOBIN_MONITOR)),

    /**
     * 浙江普可YY-106
     */
    PEARLCARE_YY106(31, "浙江普可医疗科技有限公司", "麻醉深度监测仪(YY-106)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.ANESTHESIA_DEPTH_MONITOR)),

    /**
     * 广东宝莱特 A8
     */
    BAO_LAI_TE(32, "广东宝莱特医用科技股份有限公司", "重症插件式监护仪(A8)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.BLOOD_PRESSURE_MONITOR,
                    DeviceTypeEnum.ANESTHESIA_DEPTH_MONITOR,
                    DeviceTypeEnum.HEMOGLOBIN_MONITOR,
                    DeviceTypeEnum.NORMAL_MONITOR)),

    /**
     * 宜安
     */
    YI_AN_8700_A(33, "北京宜安医疗系统股份有限公司", "麻醉机(Aeon8700A)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.ANESTHESIA_MACHINE)),

    //------------------------------------------------------
    // TCP类仪器
    //------------------------------------------------------
    /**
     * 迈瑞 BeneView T8
     */
    MAI_RUI_T8(42, "深圳迈瑞生物医疗电子股份有限公司", "监护仪(BeneViewT8)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.NORMAL_MONITOR)),

    /**
     * 迈瑞 WATOEX 65
     */
    MAI_RUI_WATOEX_65(43, "深圳迈瑞生物医疗电子股份有限公司", "麻醉机(WATOEX65)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.ANESTHESIA_MACHINE)),

    /**
     * 迈瑞WATOEX55 PRO
     */
    MAI_RUI_WATOEX_55_PRO(44, "深圳迈瑞生物医疗电子股份有限公司", "麻醉机(WATOEX55Pro)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.ANESTHESIA_MACHINE)),

    /**
     * 理邦 ELite V8
     */
    LI_BANG_ELITE_V8(45, "深圳市理邦精密仪器股份有限公司", "监护仪(ELiteV8)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.NORMAL_MONITOR,
                                        DeviceTypeEnum.BLOOD_PRESSURE_MONITOR)),


    //------------------------------------------------------
    // 串口类仪器
    //------------------------------------------------------

    /**
     * 苏州爱琴
     */
    AI_QIN_EGOS600A(50, "苏州爱琴生物医疗电子有限公司", "近红外组织血氧参数无损监测仪(EGOS600A)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.BRAIN_OXYGEN_MONITOR)),

    /**
     * 重庆名希
     */
    MING_XI(51, "重庆名希医疗器械有限公司", "脑血氧无创检测仪(MNIR-P100)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.BRAIN_OXYGEN_MONITOR)),

    /**
     * 美敦力 麻醉深度
     */
    MEIDUNLI_EEG_VISTA(52, "美国美敦力公司", "麻醉深度监护仪(EEG-VISTA)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.ANESTHESIA_DEPTH_MONITOR)),

    /**
     * 美敦力 血红蛋白
     */
    MEIDUNLI_5100C(53, "美国美敦力公司", "脑氧饱和度监测仪(5100C)",
            DeviceTypeEnum.getTypeString(DeviceTypeEnum.BRAIN_OXYGEN_MONITOR)),
    ;


    /**
     * 仪器号
     */
    private Integer deviceCode;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 仪器名称
     */
    private String deviceName;

    /**
     * 仪器类别
     */
    private String deviceType;


    DeviceInfoEnum(Integer deviceCode, String companyName, String deviceName, String deviceType) {
        this.deviceCode = deviceCode;
        this.companyName = companyName;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
    }

    /**
     * 传入仪器号得到相应的枚举
     *
     * @param code 仪器号
     * @return 对应的枚举
     */
    public static DeviceInfoEnum matchDeviceCodeEnum(Integer code) {
        for (DeviceInfoEnum deviceInfoEnum : DeviceInfoEnum.values()) {
            if (deviceInfoEnum.getDeviceCode().equals(code)) {
                return deviceInfoEnum;
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
    public static DeviceInfoEnum matchDeviceCodeEnum(String code) {
        for (DeviceInfoEnum deviceInfoEnum : DeviceInfoEnum.values()) {
            if (deviceInfoEnum.getDeviceCode().equals(Integer.parseInt(code))) {
                return deviceInfoEnum;
            }
        }
        return null;
    }

}
