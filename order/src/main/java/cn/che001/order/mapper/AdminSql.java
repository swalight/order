package cn.che001.order.mapper;


import cn.che001.order.Base.BaseProvider;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * code generator by light
 */
public class AdminSql extends BaseProvider {
    //表名
    protected  String getTableName(){
        return  "admin";
    }
    //涉及到插入和更新的字段，不在该定义中的字段不会被操作
    protected String[] getColumns(){
        return new String[]{
                "id","account","password","type"
        };
    }

    protected String _query(Map map){

        StringBuilder builder = new StringBuilder("select * from "+getTableName()+" where 1=1 ");
        
        if (StringUtils.isNotBlank(MapUtils.getString(map,"id"))){
            builder.append(" and id = #{id}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"account"))){
            builder.append(" and account = #{account}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"password"))){
            builder.append(" and password = #{password}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"type"))){
            builder.append(" and type = #{type}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "logicalDel"))) {
            builder.append(" and logicalDel = #{logicalDel} ");
        }
        return  builder.toString();
    }

    public String check(Map map){
        StringBuilder builder = new StringBuilder("select id from "+getTableName()+" ");
        builder.append("WHERE account = #{account} AND password = #{password} and logicalDel = 0");
        return builder.toString();
    }

}
