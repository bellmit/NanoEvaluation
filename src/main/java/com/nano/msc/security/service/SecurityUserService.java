package com.nano.msc.security.service;

import com.nano.msc.security.bo.SecurityPermission;
import com.nano.msc.security.bo.SecurityUser;
import com.nano.msc.security.bo.UmsAdmin;
import com.nano.msc.security.bo.UmsPermission;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author nano
 */
public interface SecurityUserService {

    /**
     * 根据用户名获取后台管理员
     */
    SecurityUser getUserByUsername(String username);

    /**
     * 注册功能
     */
    SecurityUser register(SecurityUser securityUser);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<SecurityPermission> getPermissionList(Long userId);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param user 根据用户获取其角色ID进行查询
     */
    List<SecurityPermission> getPermissionList(SecurityUser user);
}
