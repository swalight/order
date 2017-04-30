package cn.che001.order.domain;

import cn.che001.order.Base.PageEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * code generator by Shawn
 */
public class OrganizationEntity extends PageEntity {
	
	private static final long serialVersionUID = 1L;

    //
    private String orgName;

    //
    private String other;


    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
