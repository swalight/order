package cn.che001.order.mapper;


import cn.che001.order.Base.BaseProvider;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * code generator by Shawn
 */
public class TopSql extends BaseProvider {
    //表名
    protected  String getTableName(){
        return  "top";
    }
    //涉及到插入和更新的字段，不在该定义中的字段不会被操作
    protected String[] getColumns(){
        return new String[]{
                "id","top1","top2","top3","top4","top5","type","countTime"
        };
    }

    protected String _query(Map map){

        StringBuilder builder = new StringBuilder("select * from "+getTableName()+" where 1=1 ");
        
        if (StringUtils.isNotBlank(MapUtils.getString(map,"id"))){
            builder.append(" and id = #{id}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"top1"))){
            builder.append(" and top1 = #{top1}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"top2"))){
            builder.append(" and top2 = #{top2}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"top3"))){
            builder.append(" and top3 = #{top3}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"top4"))){
            builder.append(" and top4 = #{top4}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"top5"))){
            builder.append(" and top5 = #{top5}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"type"))){
            builder.append(" and type = #{type}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"countTime"))){
            builder.append(" and countTime = #{countTime}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map,"logicalDel"))){
            builder.append(" and logicalDel = #{logicalDel}");
        }
        return  builder.toString();
    }

}
