package com.nano.msc.common.vo;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 采集数据时采集器Post的实体对象
 * @author nano
 */
@Data
@Valid
public class CollectionPostEntity implements Serializable {

    /**
     * 数据传输操作码
     */
    @Min(value = 100, message = "请求Code不能低于协议最小值")
    @Max(value = 200, message = "请求Code不能高于协议最小值")
    @ApiModelProperty(example = "101")
    @NotNull(message = "请求Code不能为空")
    private Integer requestCode;

    /**
     * 采集器的MAC地址
     */
    @ApiModelProperty(example = "08:00:20:0A:8C:6D")
    @Pattern(regexp = "([A-F0-9]{2}:){5}[A-F0-9]{2}", message = "MAC地址不能为空")
    private String mac;

    /**
     * 手术顺序号
     */
    @Min(value = -1, message = "手术场次号不能低于-1")
    @NotNull(message = "手术场次号不能为空")
    private Integer operationNumber;

    /**
     * 包含信息的Data
     */
    @NotNull(message = "上传数据不能为空")
    private String data;


}
