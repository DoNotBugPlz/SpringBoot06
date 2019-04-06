package com.atguigu.springboot06.config;

import com.atguigu.springboot06.user.beans.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @Description:
 * @Author:Dn
 * @Date:Create in 10:09 PM 2019/3/27
 * @Modifid By:
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, User> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<User> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(User.class);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        return template;
    }

    @Bean
    public RedisCacheManager userCacheManager(RedisTemplate<Object, User> userRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(userRedisTemplate);
        //使用前缀，默认会将cacheName作为key的前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
