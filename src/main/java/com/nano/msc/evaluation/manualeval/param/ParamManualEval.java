package com.nano.msc.evaluation.manualeval.param;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用于人工评价的数据上传实体
 * @author nano
 */
@Data
@Valid
public class ParamManualEval implements Serializable {

    private static final long serialVersionUID = 233410345766289238L;


    /**
     * 数据传输操作码
     */
    @Min(value = 10, message = "请求Code不能低于协议最小值")
    @Max(value = 40, message = "请求Code不能高于协议最小值")
    @ApiModelProperty(example = "101")
    @NotNull(message = "请求Code不能为空")
    private Integer requestCode;

    /**
     * 包含信息的Data
     */
    @NotNull(message = "上传数据不能为空")
    private String data;
}
