package top.flvio.service;

import java.util.Map;

public interface RedisService {
    <T> Map<String,T> getMapByValue(String key);

    <T> void saveMapToValue(String redisKey, Map<String, T> map);
}
