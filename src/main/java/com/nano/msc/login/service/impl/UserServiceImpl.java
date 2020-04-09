package com.nano.msc.login.service.impl;

import com.nano.msc.login.entity.User;
import com.nano.msc.login.repository.UserRepository;
import com.nano.msc.login.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 * @author nano
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RedisTemplate stringRedisTemplate;


    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public User findByPhoneAndPassword(String phone, String password) {
        return userRepository.findByPhoneAndUserPassword(phone, password);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndUserPassword(userName, password);
    }
}
