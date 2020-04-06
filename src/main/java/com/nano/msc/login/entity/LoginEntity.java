package com.nano.msc.login.entity;

import lombok.Data;

/**
 * 用于登录的实体
 * @author nano
 */
@Data
public class LoginEntity {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

}
