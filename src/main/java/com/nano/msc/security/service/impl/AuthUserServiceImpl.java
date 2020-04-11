package com.nano.msc.security.service.impl;

import com.nano.msc.common.exceptions.Asserts;
import com.nano.msc.security.po.AuthPermission;
import com.nano.msc.security.po.AuthRolePermissionRelation;
import com.nano.msc.security.po.AuthUser;
import com.nano.msc.security.repository.AuthPermissionRepository;
import com.nano.msc.security.repository.AuthRolePermissionRepository;
import com.nano.msc.security.repository.AuthUserRepository;
import com.nano.msc.security.service.AuthUserService;
import com.nano.msc.security.service.RedisService;
import com.nano.msc.security.util.JwtTokenUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户服务实现类
 * @author nano
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(AuthUserServiceImpl.class);

    /**
     * 系统的UserDetailsService
     */
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RedisService redisService;

    /**
     * 注入JWT工具
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 密码编码器
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Token前缀 Bearer
     */
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private AuthUserRepository userRepository;

    @Autowired
    private AuthPermissionRepository permissionRepository;

    @Autowired
    private AuthRolePermissionRepository rolePermissionRepository;

    @Override
    public AuthUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AuthUser register(AuthUser user) {
        if (getUserByUsername(user.getUsername()) != null) {
            Asserts.fail("该用户名已经注册");
        }
        user.setStatus(1);
        // 将密码进行加密操作
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        return userRepository.save(user);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            // 使用用户名获取用户实体
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            // 判断密码是否正确
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            // 给用户授权
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 产生Token
            token = jwtTokenUtil.generateToken(userDetails);

            // 将token放入到Redis中--当前版本没有刷新Token的功能，一般是一天
            redisService.set("User:Login:" + username, token, 100);

        } catch (AuthenticationException e) {
            logger.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 获取权限列表
     *
     * @return 权限列表
     */
    @Override
    public List<AuthPermission> getPermissionList(Long userId) {
        // 先查找是否有这个用户
        AuthUser user = userRepository.findByUserId(userId);
        if (user == null) {
            Asserts.fail("不存在这个用户");
        }
        return getPermissionList(user);
    }

    @Override
    public List<AuthPermission> getPermissionList(AuthUser user) {
        // 得到这个角色全部的权限ID列表
        List<AuthRolePermissionRelation> rolePermissionRelationList
                = rolePermissionRepository.findAllByRoleId(user.getRoleId());

        List<AuthPermission> permissionList
                = permissionRepository.findAll();

        Set<Long> idSet = new HashSet<>();

        for (AuthRolePermissionRelation relation : rolePermissionRelationList) {
            idSet.add(relation.getPermissionId());
        }

        List<AuthPermission> resList = new ArrayList<>();

        for (AuthPermission permission : permissionList) {
            if (idSet.contains(permission.getPermissionId())) {
                resList.add(permission);
            }
        }
        if(resList.size() == 0) {
            logger.info("用户:" + user.getUsername() + " 没有找到权限");
        }
        return resList;
    }
}
