package cn.che001.order.test;

import cn.che001.order.domain.OrganizationEntity;
import cn.che001.order.utils.Utils;

import java.util.Map;

/**
 * Created by 170246 on 2017/4/17.
 */
public class Test {
    public static void main(String[] args) {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setId("0000");
        entity.setOrgName("name");
        entity.setCurrentPage(100);
        Map map = Utils.convertBeanToMap(entity);
        System.out.println(map);
    }
}
