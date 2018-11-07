package com.example.demo.Mongo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Created by 邱霏 on 2018/10/23.
 * 用於自增
 */
@Service
public class AutoIdTets {

    @Autowired
    private MongoTemplate mongoTemplate;

    public  Long getNextId(String collName) {
        Query query = Query.query(Criteria.where("collName").is(collName));
        Update update = new Update().inc("seqId", 1);
        FindAndModifyOptions options = FindAndModifyOptions.options().upsert(true).returnNew(true);
        return mongoTemplate.findAndModify(query, update, options, Sequence.class).getSeqId();
    }

}
