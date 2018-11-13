package com.example.demo.Mongo.entity;

import java.util.Date;

public class People extends BaseDocumentEntity {


    private static final long serialVersionUID = 7999473987320381242L;
    private String name;
    private Integer age;


    public People(String _id, Integer id, Boolean del, Date time, Date last, Integer operator, boolean update, boolean reload, String name, Integer age) {
        super(_id, id, del, time, last, operator, update, reload);
        this.name = name;
        this.age = age;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", _id='" + _id + '\'' +
                ", id=" + id +
                ", del=" + del +
                ", time=" + time +
                ", last=" + last +
                ", operator=" + operator +
                ", update=" + update +
                ", reload=" + reload +
                '}';
    }
}
