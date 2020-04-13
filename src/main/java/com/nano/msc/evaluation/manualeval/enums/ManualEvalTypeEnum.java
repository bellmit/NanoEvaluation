package com.nano.msc.evaluation.manualeval.enums;

/**
 * 人工问卷评价类型枚举
 * @author nano
 */
public enum ManualEvalTypeEnum {

    /**
     * 麻醉深度监护仪
     */
    APPLICATION_ANESTHESIA_DEPTH_MONITOR(11, "麻醉深度监护仪"),


    /**
     * 麻醉机
     */
    APPLICATION_ANESTHESIA_MACHINE(12, "麻醉机"),


    /**
     * 脑氧饱和度监测仪
     */
    APPLICATION_BRAIN_OXYGEN_MONITOR(13, "脑氧饱和度监测仪"),


    /**
     * 血红蛋白监测仪
     */
    APPLICATION_HEMOGLOBIN_MONITOR(14, "血红蛋白监测仪"),


    /**
     * 普通监护仪
     */
    APPLICATION_NORMAL_MONITOR(15, "普通监护仪"),


    /**
     * 呼吸机
     */
    APPLICATION_RESPIRATOR_MACHINE(16, "呼吸机"),


    /**
     * 服务体系
     */
    SERVICE_SYSTEM(21, "服务体系"),


    /**
     * 维修记录表
     */
    MAINTENANCE_RECORD(31, "维修记录表");


    private Integer code;

    private String type;

    ManualEvalTypeEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }


    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
