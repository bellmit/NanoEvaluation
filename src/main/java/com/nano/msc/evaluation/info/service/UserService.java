package com.nano.msc.evaluation.info.service;

import com.nano.msc.common.vo.ResultDTO;
import com.nano.msc.evaluation.info.entity.User;

import java.util.List;

/**
 * 用户服务
 * @author nano
 */
public interface UserService {

    User insertUser(User user);

    List<User> getAllUser();


    User getUserById(Integer id);

    User getUserByPhone(String phone);

}
