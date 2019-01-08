package com.jelly.redis.study.config;

import com.jelly.redis.study.utils.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Bean
    public RedisUtils redisUtils(StringRedisTemplate redisTemplate){
        RedisUtils redisUtils=new RedisUtils();
        redisUtils.setRedisTemplate(redisTemplate);
        return redisUtils;
    }
    @Bean
    public StringRedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory){
        return new StringRedisTemplate(jedisConnectionFactory);
    }
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig poolConfig){
        JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("127.0.0.1");
        jedisConnectionFactory.setPassword("");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPoolConfig(poolConfig);
        return jedisConnectionFactory;
    }
    @Bean
    public  JedisPoolConfig poolConfig(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(1000);
        jedisPoolConfig.setMaxIdle(300);
        jedisPoolConfig.setMaxTotal(600);
        jedisPoolConfig.setMaxWaitMillis(1000);
        jedisPoolConfig.setTestOnBorrow(true);
        return  jedisPoolConfig;
    }
}
