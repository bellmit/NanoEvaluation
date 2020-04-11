package com.nano.msc.auth.bo;

import com.nano.msc.auth.po.AuthPermission;
import com.nano.msc.auth.po.AuthUser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SpringSecurity需要的用户详情
 * @author nano
 */
public class AuthUserDetails implements UserDetails {

    /**
     * 用户类
     */
    private AuthUser user;

    /**
     * 权限列表
     */
    private List<AuthPermission> permissionList;


    public AuthUserDetails(AuthUser user, List<AuthPermission> permissionList) {
        this.user = user;
        this.permissionList = permissionList;
    }

    /**
     * 获取权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getValue() != null)
                // 传入权限值
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                // 将数据库中的权限值转换为权限列表
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus().equals(1);
    }
}
