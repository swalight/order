package cn.che001.order.domain;

import cn.che001.order.Base.PageEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * code generator by Shawn
 */
public class OrderEntity extends PageEntity {
	
	private static final long serialVersionUID = 1L;

    //
    private String name;

    //0-早餐 1-午餐 2-饮料
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
