package cn.che001.order.domain;

import cn.che001.order.Base.PageEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * code generator by Shawn
 */
public class OrderInfoEntity extends PageEntity {
	
	private static final long serialVersionUID = 1L;

    //
    private String personId;

    //
    private String orderId;

    //1 2 3 4 5 6 7 七天
    private Integer week;

    //0-早餐 1-午餐 2-饮料
    private Integer type;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getWeek() {
        return week;
    }

    /**
     * 1 2 3 4 5 6 7 七天
     * @param week
     */
    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getType() {
        return type;
    }

    /**
     * 0-早餐 1-午餐 2-饮料
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
