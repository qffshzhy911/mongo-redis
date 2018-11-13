package com.example.demo.Config;


import com.example.demo.Redis.KryoRedisSerializer;
import com.example.demo.Redis.User;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.util.Arrays;


@Configuration
public class RedisConfig {

    /**
     * redisTemplate 序列化使用的Serializeable, 存储二进制字节码, 所以自定义序列化类
     *
     * 原始 RedisTemplate 内有各種序列化器
     * 默认使用 JdkSerializationRedisSerializer
     *
     * 改寫默認的  RedisAutoConfiguration      redisTemplate  方法
     *
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

    /**
     * 自定义key生成器
     * key
     */

    @Bean("redisKeyGenerator")
    public KeyGenerator redisKeyGenerator(){

        return   new KeyGenerator(){

            @Override
              public Object generate(Object o, Method method, Object... objects) {
             // System.err.println("调用自定义redisKeyGenerator");
                return method.getName()+"["+ Arrays.asList(objects)  +"]";
            }
        };


    }
}
