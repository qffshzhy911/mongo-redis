package com.example.demo.Mongo;

/**
 * Created by 邱霏 on 2018/7/24.
 */

import com.example.demo.Mongo.entity.Sequence;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

import javax.annotation.Resource;
import java.lang.reflect.Field;

public class SaveMongoEventListener extends AbstractMongoEventListener<Object> {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Object> event) {
        if (event != null && event.getSource() != null) {
            ReflectionUtils.doWithFields(event.getSource().getClass(), new FieldCallback() {

                @Override
                public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                    if (field.isAnnotationPresent(AutoId.class)) {
                        String collName = event.getSource().getClass().getSimpleName();
                        if (event.getSource().getClass().isAnnotationPresent(Document.class)) {
                            collName = event.getSource().getClass().getAnnotation(Document.class).collection();
                        }
                        field.set(event.getSource(), getNextId(collName));
                    }
                }

            });
        }
    }

    public Long getNextId(String collName) {
        Query query = Query.query(Criteria.where("collName").is(collName));
        Update update = new Update().inc("seqId", 1);
        FindAndModifyOptions options = FindAndModifyOptions.options().upsert(true).returnNew(true);
        return mongoTemplate.findAndModify(query, update, options, Sequence.class).getSeqId();
    }
}