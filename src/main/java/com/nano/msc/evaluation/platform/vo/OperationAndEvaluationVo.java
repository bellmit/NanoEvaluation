package com.nano.msc.evaluation.platform.vo;

import com.nano.msc.evaluation.info.entity.InfoEvaluation;
import com.nano.msc.evaluation.info.entity.InfoOperation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 仪器展示卡片中同时存放手术信息与仪器评价信息的Vo
 *
 * @author: nano
 * @time: 2020/6/8 15:38
 */
@Data
public class OperationAndEvaluationVo implements Serializable {

	private InfoOperation operationInfo;
	private InfoEvaluationVo evaluationInfo;

	public OperationAndEvaluationVo() {
	}

	public OperationAndEvaluationVo(InfoOperation operationInfo, InfoEvaluationVo evaluationInfo) {
		this.operationInfo = operationInfo;
		this.evaluationInfo = evaluationInfo;
	}

	/**
	 * 生成Vo List
	 *
	 * @param operationList    手术信息列表
	 * @param evaluationVoList 评价信息列表
	 * @return 合成的信息列表
	 */
	public static List<OperationAndEvaluationVo> generateOperationAndEvaluationVoList(List<InfoOperation> operationList, List<InfoEvaluationVo> evaluationVoList) {

		List<OperationAndEvaluationVo> resList = new ArrayList<>(operationList.size());

		for (InfoOperation operation : operationList) {
			InfoEvaluationVo evaluationVo = findMatchEvaluationVo(operation.getOperationNumber(), evaluationVoList);
			if (evaluationVo != null) {
				resList.add(new OperationAndEvaluationVo(operation, evaluationVo));
			} else {
				resList.add(new OperationAndEvaluationVo(operation, new InfoEvaluationVo()));
			}
		}
		return resList;
	}


	private static InfoEvaluationVo findMatchEvaluationVo(int operationNumber, List<InfoEvaluationVo> evaluationVoList) {
		for (InfoEvaluationVo evaluationVo : evaluationVoList) {
			// 匹配上了
			if (evaluationVo.getOperationNumber() == operationNumber) {
				return evaluationVo;
			}
		}
		return null;
	}
}
