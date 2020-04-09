package com.nano.msc.common.vo;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @Min(value = 0, message = "The type must be greater than the protocol minimum")
    @Max(value = 200, message = "The type must be less than the protocol maximum")
    @NotNull(message = "The requestCode cannot be empty")
    private Integer requestCode;

    /**
     * 采集器的MAC地址
     */
    @Pattern(regexp = "([A-F0-9]{2}:){5}[A-F0-9]{2}", message = "The mac cannot be empty")
    private String mac;

    /**
     * 手术顺序号
     */
    @Min(value = -1, message = "The operationNumber must be greater than the protocol minimum")
    @NotNull(message = "The operationNumber cannot be empty")
    private Integer operationNumber;

    /**
     * 包含信息的Data
     */
    @NotNull(message = "The data cannot be empty")
    private String data;


}
