package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.common.util.RedisUtil;
import com.nano.msc.evaluation.info.entity.User;
import com.nano.msc.evaluation.info.repository.UserRepository;
import com.nano.msc.evaluation.info.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    public User getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }
}
