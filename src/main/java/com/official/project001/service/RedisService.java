package com.official.project001.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key,String value){
        ValueOperations<String,String> valuesOperation = stringRedisTemplate.opsForValue();
        valuesOperation.set(key,value);
    }

    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}
