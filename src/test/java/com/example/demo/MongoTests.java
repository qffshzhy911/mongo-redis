package com.example.demo;

import com.example.demo.Mongo.entity.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTests {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void mongodbtest() {
        People people=new People();
        people.setName("Albert");
        people.setAge(19);
        mongoTemplate.save(people);


    }





}
