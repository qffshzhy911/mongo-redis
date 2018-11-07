package com.example.demo.Mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * 用來保存每個表的 id mongodb的自增字段
 */
@Document(collection="sequence")
public class Sequence {
    @Id
    private String id;
    @Field("coll_name") //表名
    private String collName;
    @Field("seq_id") //該表的ID
    private Long seqId;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCollName() {
        return collName;
    }
    public void setCollName(String collName) {
        this.collName = collName;
    }
    public Long getSeqId() {
        return seqId;
    }
    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }
}

