package com.ryx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
            RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
            template.setConnectionFactory(factory);
            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
            template.setKeySerializer(stringRedisSerializer);
            template.setHashKeySerializer(stringRedisSerializer);
            template.setValueSerializer(stringRedisSerializer);
            template.setHashValueSerializer(stringRedisSerializer);
            template.afterPropertiesSet();
            return template;
    }
}
