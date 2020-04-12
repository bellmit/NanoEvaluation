package com.nano.msc.auth.param;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用于登录的实体
 * @author nano
 */
@Data
@Valid
public class ParamLogin implements Serializable {

    private static final long serialVersionUID = 1823209480923L;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true, example = "nano")
    @NotNull(message = "用户名不能为空")
    private String username;


    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    @NotNull(message = "密码不能为空")
    private String password;

    /**
     * 年龄
     */
    @NotBlank
    private Integer age;

}
