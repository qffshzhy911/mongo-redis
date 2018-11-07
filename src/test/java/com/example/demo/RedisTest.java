package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.redis.core.RedisTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    //edisTemplate使用的序列类在在操作数据的时候，比如说存入数据会将数据先序列化成字节数组
    //然后在存入Redis数据库，这个时候打开Redis查看的时候，你会看到你的数据不是以可读的形式
    //展现的，而是以字节数组显示
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void savetemp1(){

        stringRedisTemplate.opsForValue().set("zzp1","big z");
        redisTemplate.opsForValue().set("zzp2","big z");
    }
    //当你的redis数据库里面本来存的是字符串数据或者你要存取的数据就是字符串类型数据的时候，那么你就使用StringRedisTemplate即可，
    //但是如果你的数据是复杂的对象类型，而取出的时候又不想做任何的数据转换，直接从Redis里面取出一个对象，那么使用RedisTemplate是
    //更好的选择。


}
