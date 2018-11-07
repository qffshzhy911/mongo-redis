package com.example.demo.Mongo.entity;

import com.example.demo.Mongo.AutoId;
import org.springframework.data.annotation.Id;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Don.Zhang
 * Date: 2018/7/9
 */
@MappedSuperclass
public abstract class BaseDocumentEntity implements Serializable {
    @Id
    protected String _id;
    @AutoId
    protected Integer id;
    protected Boolean del = false;
    @Temporal(TemporalType.TIMESTAMP)
    //數據生成的時間
    protected Date time;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date last;
    protected Integer operator;
    //是否需要进行更新  默认不需要
    protected  boolean update= false;

    //是否已经执行每日重读 用于看板的夜间自动刷新当天数据
    protected boolean reload=true;

    public BaseDocumentEntity(String _id, Integer id, Boolean del, Date time, Date last, Integer operator, boolean update, boolean reload) {
        this._id = _id;
        this.id = id;
        this.del = del;
        this.time = time;
        this.last = last;
        this.operator = operator;
        this.update = update;
        this.reload = reload;
    }

    public BaseDocumentEntity(String _id, Integer id, Boolean del, Date time, Date last, Integer operator, boolean update) {
        this._id = _id;
        this.id = id;
        this.del = del;
        this.time = time;
        this.last = last;
        this.operator = operator;
        this.update = update;
    }

    public BaseDocumentEntity() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getLast() {
        return last;
    }

    public void setLast(Date last) {
        this.last = last;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isReload() {
        return reload;
    }

    public void setReload(boolean reload) {
        this.reload = reload;
    }
}
