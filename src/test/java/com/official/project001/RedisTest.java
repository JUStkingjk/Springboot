package com.official.project001;

import com.alibaba.fastjson.JSON;
import com.official.project001.entity.Login;
import com.official.project001.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.official.project001")
@SpringBootTest
public class RedisTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Resource
    private RedisService redisService;

    @Test
    public void contextloads(){
        redisService.setString("key one","value one");
        logger.info("key 1: {}",redisService.getString("key one"));

        Login login = new Login();

        login.setUsername("redis username");
        login.setPassword("redis password");
        redisService.setString("key two", JSON.toJSONString(login));
        logger.info("key 2:  {}",redisService.getString("key two"));

    }

}
