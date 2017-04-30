package cn.che001.order.mapper;


import cn.che001.order.Base.BaseProvider;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * code generator by Shawn
 */
public class PersonSql extends BaseProvider {
    //表名
    protected  String getTableName(){
        return  "person";
    }
    //涉及到插入和更新的字段，不在该定义中的字段不会被操作
    protected String[] getColumns(){
        return new String[]{
                "id","name","orgId"
        };
    }

    protected String _query(Map map){

        StringBuilder builder = new StringBuilder("select * from "+getTableName()+" where 1=1 ");
        
        if (StringUtils.isNotBlank(MapUtils.getString(map,"id"))){
            builder.append(" and id = #{id}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"name"))){
            builder.append(" and name = #{name}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"orgId"))){
            builder.append(" and orgId = #{orgId}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"logicalDel"))){
            builder.append(" and logicalDel = #{logicalDel}");
        }
        return  builder.toString();
    }

}
