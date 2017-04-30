package cn.che001.order.mapper;

import cn.che001.order.Base.BaseProvider;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * code generator by Shawn
 */
public class OrderSql extends BaseProvider {
    //表名
    protected  String getTableName(){
        return  "`order`";
    }
    //涉及到插入和更新的字段，不在该定义中的字段不会被操作
    protected String[] getColumns(){
        return new String[]{
                "id","name","type","logicalDel"
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
        if (StringUtils.isNotBlank(MapUtils.getString(map,"type"))){
            builder.append(" and type = #{type}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"logicalDel"))){
            Integer log = Integer.parseInt(MapUtils.getString(map,"logicalDel"));
            if (log==3){

            }else {
                builder.append(" and logicalDel = #{logicalDel}");
            }
        }
        return  builder.toString();
    }

    public String logicalDel(Map map){
        String sql = "UPDATE `order` SET logicalDel = 1 WHERE id = #{id} and logicalDel = 0";
        return sql;
    }

    public String recover(Map map){
        String sql = "UPDATE `order` SET logicalDel = 0 WHERE id = #{id} and logicalDel = 0";
        return sql;
    }

}
