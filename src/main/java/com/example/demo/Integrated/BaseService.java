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

    /**
     * sync 异步模式
     */

    /**
     * 1   自动配置类:  public class CacheAutoConfiguration
     * 2   缓存配置类  static class CacheConfigurationImportSelector implements ImportSelector
     *    有10种
     *    1.org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *    2.org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     *    。
     *    。
     *    。
     *    10. org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *
     *3
     *    1 默認生效 ： SimpleCacheConfiguration:
     *
     *    2 現在生效 ：RedisCacheConfiguration
     *
     *4
     *   1 給容器注冊  RedisCacheManager   緩存管理器   其最終實現了 CacheManager
     *      CacheManager  根據緩存名稱  獲得組件
     *
     *
     */




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
     * cacheNames  缓存组件名称  当成redis 的“表名”
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
