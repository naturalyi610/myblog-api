package top.flvio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.flvio.service.RedisService;

import java.util.Map;

/**
*@Author:flvio
*@Description:读写Redis相关操作
*@Params:
*/
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate jsonRedisTemplate;
    @Override
    public <T> Map<String, T> getMapByValue(String key) {
        Map<String,T> redisResult = (Map<String, T>) jsonRedisTemplate.opsForValue().get(key);
        return redisResult;
    }

    @Override
    public <T> void saveMapToValue(String key, Map<String, T> map) {
        jsonRedisTemplate.opsForValue().set(key,map);
    }
}
