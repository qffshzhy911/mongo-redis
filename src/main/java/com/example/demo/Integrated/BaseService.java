package com.example.demo.Integrated;

import com.example.demo.Mongo.entity.People;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import javax.print.Doc;
import java.util.List;
import java.util.Queue;


@Service
public class BaseService {

    @Autowired
    private MongoTemplate mongoTemplate;

    void save(People people){
        mongoTemplate.save(people);
    }

    @Cacheable(cacheNames = "People")
    public List<People> findAll(){
        System.err.println("查询所有People");
        return  mongoTemplate.findAll(People.class);
    }

    /**
     * unless = "#result==null   返回值为null 则不缓存
     * @param name
     * @return
     */
    @Cacheable(cacheNames = "People")
    public People findone(String name){
        System.err.println("查询名称为"+name);
        Document document=new Document();
        document.append("name",name);
        Query query=new BasicQuery(document);
        People people = mongoTemplate.findOne(query, People.class);

        return  mongoTemplate.findOne(query, People.class);
    }


}
