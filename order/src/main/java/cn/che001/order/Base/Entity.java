package cn.che001.order.Base;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by light on 2017/4/17.
 */
public class Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    public Entity() {
    }

    protected  Object id;

    protected Integer logicalDel = Integer.valueOf(0);

    protected Date createTime;

    protected Date updateTime;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getLogicalDel() {
        return logicalDel;
    }

    public void setLogicalDel(Integer logicalDel) {
        this.logicalDel = logicalDel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
