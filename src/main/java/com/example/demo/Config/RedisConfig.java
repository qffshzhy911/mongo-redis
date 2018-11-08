package com.example.demo.Config;


import com.example.demo.Redis.KryoRedisSerializer;
import com.example.demo.Redis.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class RedisConfig {

    /**
     * redisTemplate 序列化使用的Serializeable, 存储二进制字节码, 所以自定义序列化类
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate redisKryoTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        //使用Json 序列化
        //Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
      // redis value使用的序列化器
        template.setValueSerializer(new KryoRedisSerializer<>(Object.class));
      //   redis key使用的序列化器
        template.setKeySerializer(new StringRedisSerializer());

  //      template.setDefaultSerializer(new KryoRedisSerializer<>(Object.class));

        template.afterPropertiesSet();

        return template;
    }
}
