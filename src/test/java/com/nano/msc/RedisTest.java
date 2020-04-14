package com.nano.msc;

import com.nano.msc.redis.service.RedisService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void testRedisService() {

        System.out.println(redisService.get("123"));

    }

}
