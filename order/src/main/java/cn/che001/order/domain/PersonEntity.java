package cn.che001.order.domain;

import cn.che001.order.Base.PageEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * code generator by Shawn
 */
public class PersonEntity extends PageEntity {
	
	private static final long serialVersionUID = 1L;

    //
    private String name;

    //机构Id
    private String orgId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
