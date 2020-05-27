package com.nano.msc.evaluation.enums;

import lombok.Getter;

/**
 * 仪器类型枚举
 * @author cz
 */
@Getter
public enum DeviceTypeEnum {

	/**
	 * 麻醉深度监护仪
	 */
	ANESTHESIA_DEPTH_MONITOR("1", "麻醉深度监护仪"),

	/**
	 * 麻醉机
	 */
	ANESTHESIA_MACHINE("2", "麻醉机"),

	/**
	 * 脑氧饱和度监护仪
	 */
	BRAIN_OXYGEN_MONITOR("3", "无创脑氧饱和度监护仪"),

	/**
	 * 血红蛋白监测仪
	 */
	HEMOGLOBIN_MONITOR("4", "无创血红蛋白监测仪"),

	/**
	 * 普通监护仪
	 */
	NORMAL_MONITOR("5", "普通监护仪"),

	/**
	 * 呼吸机
	 */
	RESPIRATOR_MACHINE("6", "呼吸机"),

	/**
	 * 无创血压监测仪
	 */
	BLOOD_PRESSURE_MONITOR("7", "无创血压监测仪")
	;


	private String code;

	private String typeName;

	DeviceTypeEnum(String code, String typeName) {
		this.code = code;
		this.typeName = typeName;
	}

	/**
	 * 传入类型数组
	 *
	 * @param types 类型数组
	 * @return 得到类型字符串
	 */
	public static String getTypeString(DeviceTypeEnum... types) {
		if (types.length == 1) {
			return types[0].getCode();
		}
		StringBuffer stringBuffer = new StringBuffer();
		for (DeviceTypeEnum typeEnum : types) {
			stringBuffer.append(typeEnum.code).append("#");
		}
		// 去掉最后一个#号
		return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
	}
}
