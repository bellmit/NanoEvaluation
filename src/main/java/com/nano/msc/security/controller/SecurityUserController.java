package com.nano.msc.security.controller;


import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.security.bo.SecurityPermission;
import com.nano.msc.security.bo.SecurityUser;
import com.nano.msc.security.entity.LoginEntity;
import com.nano.msc.security.service.SecurityUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户登录API
 * @author nano
 */
@RestController
@RequestMapping("/user")
@Api(tags = "UmsAdminController", description = "后台用户管理")
public class SecurityUserController {

    @Autowired
    private SecurityUserService userService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<SecurityUser> register(@RequestBody SecurityUser umsAdminParam, BindingResult result) {
        SecurityUser umsAdmin = userService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody LoginEntity loginEntity, BindingResult result) {
        String token = userService.login(loginEntity.getUsername(), loginEntity.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SecurityPermission>> getPermissionList(@PathVariable Long userId) {

        List<SecurityPermission> permissionList = userService.getPermissionList(userId);
        return CommonResult.success(permissionList);
    }
}
