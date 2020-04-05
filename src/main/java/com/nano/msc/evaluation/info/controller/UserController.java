package com.nano.msc.evaluation.info.controller;


import com.nano.msc.common.util.RedisUtil;
import com.nano.msc.common.vo.ResultDTO;
import com.nano.msc.common.vo.ResultVO;
import com.nano.msc.evaluation.info.entity.User;
import com.nano.msc.evaluation.info.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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
}
