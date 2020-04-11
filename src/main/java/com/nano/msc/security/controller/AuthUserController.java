package com.nano.msc.security.controller;


import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.security.po.AuthPermission;
import com.nano.msc.security.po.AuthUser;
import com.nano.msc.security.param.LoginParam;
import com.nano.msc.security.service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户登录API
 * @author nano
 */
@RestController
@RequestMapping("/user")
@Api(tags = "UserController", description = "后台用户管理")
public class AuthUserController {

    @Autowired
    private AuthUserService userService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<AuthUser> register(@RequestBody AuthUser umsAdminParam, BindingResult result) {
        AuthUser umsAdmin = userService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@Valid @RequestBody LoginParam loginParam, BindingResult result) {
        String token = userService.login(loginParam.getUsername(), loginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @PreAuthorize("hasAuthority('root:permission:read')")
    @RequestMapping(value = "/permission/{userId}", method = RequestMethod.GET)
    public CommonResult<List<AuthPermission>> getPermissionList(@PathVariable Long userId) {

        List<AuthPermission> permissionList = userService.getPermissionList(userId);
        return CommonResult.success(permissionList);
    }


    @GetMapping("/logout")
    public CommonResult<String> logout() {
        return CommonResult.success("您已成功退出");
    }

}
