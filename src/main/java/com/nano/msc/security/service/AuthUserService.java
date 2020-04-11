package com.nano.msc.security.service;

import com.nano.msc.security.po.AuthPermission;
import com.nano.msc.security.po.AuthUser;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author nano
 */
public interface AuthUserService {

    /**
     * 根据用户名获取后台管理员
     */
    AuthUser getUserByUsername(String username);

    /**
     * 注册功能
     */
    AuthUser register(AuthUser authUser);

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
    List<AuthPermission> getPermissionList(Long userId);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param user 根据用户获取其角色ID进行查询
     */
    List<AuthPermission> getPermissionList(AuthUser user);
}
