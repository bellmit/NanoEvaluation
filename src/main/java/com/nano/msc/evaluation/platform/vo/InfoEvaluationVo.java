package com.nano.msc.evaluation.platform.vo;

import com.nano.msc.evaluation.enums.DeviceInfoEnum;
import com.nano.msc.evaluation.enums.evaluation.EvaluationExperienceLevelEnum;
import com.nano.msc.evaluation.enums.evaluation.EvaluationReliabilityLevelEnum;
import com.nano.msc.evaluation.info.entity.InfoEvaluation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 平台专用:术后仪器评价传给前端的实体对象
 *
 * @author: nano
 * @time: 2020/5/29 16:49
 */
@Data
@NoArgsConstructor
public class InfoEvaluationVo implements Serializable {

	/**
	 * 标记id，自动增长
	 */
	private Integer id;

	/**
	 * 手术顺序号
	 */
	private Integer operationNumber;

	/**
	 * 仪器代号
	 */
	private Integer deviceCode;

	/**
	 * 仪器序列号
	 */
	private String serialNumber;

	/**
	 * 使用科室
	 */
	private String deviceDepartment;

	/**
	 * 使用评价等级
	 */
	private String experienceLevel;

	/**
	 * 可靠性等级
	 */
	private String reliabilityLevel;

	/**
	 * 是否有错误信息
	 */
	private String hasError;

	/**
	 * 错误原因
	 */
	private String knownError;

	/**
	 * 其他错误
	 */
	private String otherError;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 记录人签名
	 */
	private String recordName;


	//-------------以下补充仪器信息--------------------

	/**
	 * 仪器名称
	 */
	private String deviceName;

	/**
	 * 公司名称
	 */
	private String companyName;



	/**
	 * 由术后评价信息生成术后评价信息Vo
	 *
	 * 这里插入其他信息。并对记录的数字信息进行转换
	 *
	 * @param evaluationList 评价信息列表
	 * @return 评价信息Vo
	 */
	public static List<InfoEvaluationVo> generateEvaluationVo(List<InfoEvaluation> evaluationList) {

		List<InfoEvaluationVo> evaluationVoList = new ArrayList<>(evaluationList.size());
		for (InfoEvaluation evaluation : evaluationList) {
			InfoEvaluationVo evaluationVo = new InfoEvaluationVo();
			BeanUtil.copyProperties(evaluation, evaluationVo);
			// 转换使用满意度
			evaluationVo.setExperienceLevel(EvaluationExperienceLevelEnum.getExperienceLevelForPaltform(evaluationVo.getExperienceLevel()));
			// 转换可靠性满意度
			evaluationVo.setReliabilityLevel(EvaluationReliabilityLevelEnum.getReliabilityLevelForPaltform(evaluationVo.getReliabilityLevel()));

			// 已知的故障号：需要进行转换成实际的故障
			evaluationVo.setKnownError(InfoEvaluation.convertErrorCodeToErrorString(evaluation.getKnownError()));

			DeviceInfoEnum infoEnum = DeviceInfoEnum.matchDeviceCodeEnum(evaluation.getDeviceCode());
			if (infoEnum != null) {
				evaluationVo.setCompanyName(infoEnum.getCompanyName());
				evaluationVo.setDeviceName(infoEnum.getDeviceName());
			}
			evaluationVoList.add(evaluationVo);
		}
		return evaluationVoList;
	}




}
