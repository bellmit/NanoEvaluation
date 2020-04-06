package com.nano.msc.login.controller;


import com.nano.msc.common.vo.ResultDTO;
import com.nano.msc.common.vo.ResultVO;
import com.nano.msc.login.entity.LoginEntity;
import com.nano.msc.login.entity.User;
import com.nano.msc.login.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户前端控制器
 * @author nano
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户功能Controller")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户")
    @PostMapping("/add")
    public ResultDTO addUser(@RequestBody User user) {
        return ResultDTO.checkAndReturn(userService.insertUser(user));
    }

    @ApiOperation(value = "得到全部用户")
    @GetMapping("/findAll")
    public ResultDTO findAllUsers() {
        return ResultDTO.success(userService.getAllUser());
    }


    // TODO:待完成
    @PostMapping("/login")
    public ResultVO login(@RequestBody LoginEntity loginEntity) {

        String userName = loginEntity.getUserName();
        String phone = loginEntity.getPhone();
        String password = loginEntity.getPassword();

        // 判断是否为空
        if (StringUtils.isEmpty(userName) && StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            return ResultVO.checkAndReturn(ResultDTO.dataFormatError("数据条件缺失"));
        }

        return null;
    }

}
