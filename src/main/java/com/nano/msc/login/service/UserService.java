package com.nano.msc.login.service;

import com.nano.msc.login.entity.User;

import java.util.List;

/**
 * 用户服务
 * @author nano
 */
public interface UserService {

    User insertUser(User user);

    List<User> getAllUser();


    User findById(Integer id);

    User findByPhone(String phone);

    User findByPhoneAndPassword(String phone, String password);

    User findByUserNameAndPassword(String userName, String password);
}
