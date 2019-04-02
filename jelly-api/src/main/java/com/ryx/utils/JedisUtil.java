package com.ryx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

/**
 * JedisUtil(推荐存Byte数组，存Json字符串效率更慢)
 * @author 
 * @date 
 */
@Component
public final class JedisUtil {

   @Autowired
   private RedisTemplate<String,Object> redisTemplate;

    public  Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 设置redis键值-object-expiretime
     * @param key
	 * @param value
	 * @param expiretime
     * @return java.lang.String
     * @author 
     * @date 2018/9/4 15:50
     */
    public  void set(String key, Object value, int expiretime) {
        redisTemplate.opsForValue().set(key,value,expiretime,TimeUnit.SECONDS);
    }


    /**
     * 删除key
     * @param key
     * @return java.lang.Long
     * @author 
     * @date 2018/9/4 15:50
     */
    public  void delKey(String key) {
       redisTemplate.delete(key);
    }

    /**
     * key是否存在
     * @param key
     * @return java.lang.Boolean
     * @author 
     * @date 2018/9/4 15:51
     */
    public  Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 根据key 获取过期时间
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */

    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }


}
