package cn.che001.order.domain;

import cn.che001.order.Base.PageEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;

/**
 * code generator by Shawn
 */
public class TopEntity extends PageEntity {
	
	private static final long serialVersionUID = 1L;

    //
    private String top1;

    //
    private String top2;

    //
    private String top3;

    //
    private String top4;

    //
    private String top5;

    //
    private Date countTime;

    private Integer type;
    
    public String getTop1() {
        return top1;
    }

    public void setTop1(String top1) {
        this.top1 = top1;
    }

    public String getTop2() {
        return top2;
    }

    public void setTop2(String top2) {
        this.top2 = top2;
    }

    public String getTop3() {
        return top3;
    }

    public void setTop3(String top3) {
        this.top3 = top3;
    }

    public String getTop4() {
        return top4;
    }

    public void setTop4(String top4) {
        this.top4 = top4;
    }

    public String getTop5() {
        return top5;
    }

    public void setTop5(String top5) {
        this.top5 = top5;
    }

    public Date getCountTime() {
        return countTime;
    }

    public void setCountTime(Date countTime) {
        this.countTime = countTime;
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
