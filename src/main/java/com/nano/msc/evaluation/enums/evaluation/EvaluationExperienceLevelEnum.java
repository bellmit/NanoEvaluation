package com.nano.msc.evaluation.enums.evaluation;

import lombok.Getter;

/**
 * 评价体验等级枚举
 *
 * @author: nano
 * @time: 2020/5/29 18:29
 */
@Getter
public enum  EvaluationExperienceLevelEnum {

	/**
	 * 非常满意
	 */
	VERY_GOOD("1", "非常满意"),

	/**
	 * 满意
	 */
	GOOD("2", "满意"),

	/**
	 * 一般
	 */
	JUST_SO_SO("3", "一般"),

	/**
	 * 不满意
	 */
	BAD("4", "不满意"),

	/**
	 * 非常不满意
	 */
	VERY_BAD("5", "非常不满意")
	;


	private String level;


	private String msg;


	EvaluationExperienceLevelEnum(String level, String msg) {
		this.level = level;
		this.msg = msg;
	}

	/**
	 * 传入等级信息并得到字符串
	 *
	 * @param level 等级
	 * @return 信息
	 */
	public static String getExperienceLevelForPaltform(String level){
		for (EvaluationExperienceLevelEnum levelEnum : EvaluationExperienceLevelEnum.values()) {
			if (levelEnum.level.equals(level)) {
				return levelEnum.getMsg();
			}
		}
		return "";
	}
}
