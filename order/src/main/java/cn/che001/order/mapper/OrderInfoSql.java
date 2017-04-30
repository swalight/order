package cn.che001.order.mapper;


import cn.che001.order.Base.BaseProvider;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * code generator by light
 */
public class OrderInfoSql extends BaseProvider {
    //表名
    protected String getTableName() {
        return "orderInfo";
    }

    //涉及到插入和更新的字段，不在该定义中的字段不会被操作
    protected String[] getColumns() {
        return new String[]{
                "id", "personId", "orderId", "week", "type"
        };
    }

    public String queryLunch(Map map) {
        StringBuilder builder = new StringBuilder("SELECT " +
                " mm.personName personName, " +
                "MAX(mm.orgName) orgName, " +
                "MAX(mm.personId) personId, " +
                "MAX(CASE WHEN (mm.`week` = 1 AND mm.menuType = 1) THEN menuName ELSE '' END ) menu1, " +
                "MAX(CASE WHEN (mm.`week` = 2 AND mm.menuType = 1) THEN menuName ELSE '' END ) menu2, " +
                "MAX(CASE WHEN (mm.`week` = 3 AND mm.menuType = 1) THEN menuName ELSE '' END ) menu3, " +
                "MAX(CASE WHEN (mm.`week` = 4 AND mm.menuType = 1) THEN menuName ELSE '' END ) menu4, " +
                "MAX(CASE WHEN (mm.`week` = 5 AND mm.menuType = 1) THEN menuName ELSE '' END ) menu5, " +
                "MAX(CASE WHEN (mm.`week` = 6 AND mm.menuType = 1) THEN menuName ELSE '' END ) menu6, " +
                "MAX(CASE WHEN (mm.`week` = 7 AND mm.menuType = 1) THEN menuName ELSE '' END ) menu7, " +

                "MAX(CASE WHEN (mm.`week` = 1 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink1, " +
                "MAX(CASE WHEN (mm.`week` = 2 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink2, " +
                "MAX(CASE WHEN (mm.`week` = 3 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink3, " +
                "MAX(CASE WHEN (mm.`week` = 4 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink4, " +
                "MAX(CASE WHEN (mm.`week` = 5 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink5, " +
                "MAX(CASE WHEN (mm.`week` = 6 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink6, " +
                "MAX(CASE WHEN (mm.`week` = 7 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink7 " +

                "FROM (SELECT " +
                "p.`name` AS personName," +
                "org.orgName AS orgName," +
                "info.personId AS personId," +
                "info.`week` AS `week`," +
                "info.type AS menuType," +
                "ord. NAME AS menuName" +
                " FROM person p");
        builder.append(" INNER JOIN organization org ON p.orgId = org.id");

        if (StringUtils.isNotBlank(MapUtils.getString(map, "orgId"))) {
            builder.append(" and p.orgId = #{orgId}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "personName"))) {
            builder.append(" and p.name = #{personName}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "personId"))) {
            builder.append(" and p.id = #{personId}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "orgName"))) {
            builder.append(" and org.orgName = #{orgName} ");
        }

        builder.append(" INNER JOIN orderInfo info ON p.id = info.personId ");
        builder.append(" INNER JOIN `order` ord ON info.orderId = ord.id and ord.logicalDel = 0");

        builder.append(" ) AS mm GROUP BY mm.personName ORDER BY mm.personName DESC ");
        return builder.toString();
    }

    public String queryBreakfast(Map map) {
        StringBuilder builder = new StringBuilder("SELECT " +
                " mm.personName personName, " +
                "MAX(mm.orgName) orgName, " +
                "MAX(mm.personId) personId, " +
                "MAX(CASE WHEN (mm.`week` = 1 AND mm.menuType = 0) THEN menuName ELSE '' END ) menu1, " +
                "MAX(CASE WHEN (mm.`week` = 2 AND mm.menuType = 0) THEN menuName ELSE '' END ) menu2, " +
                "MAX(CASE WHEN (mm.`week` = 3 AND mm.menuType = 0) THEN menuName ELSE '' END ) menu3, " +
                "MAX(CASE WHEN (mm.`week` = 4 AND mm.menuType = 0) THEN menuName ELSE '' END ) menu4, " +
                "MAX(CASE WHEN (mm.`week` = 5 AND mm.menuType = 0) THEN menuName ELSE '' END ) menu5, " +
                "MAX(CASE WHEN (mm.`week` = 6 AND mm.menuType = 0) THEN menuName ELSE '' END ) menu6, " +
                "MAX(CASE WHEN (mm.`week` = 7 AND mm.menuType = 0) THEN menuName ELSE '' END ) menu7, " +

                "MAX(CASE WHEN (mm.`week` = 1 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink1, " +
                "MAX(CASE WHEN (mm.`week` = 2 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink2, " +
                "MAX(CASE WHEN (mm.`week` = 3 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink3, " +
                "MAX(CASE WHEN (mm.`week` = 4 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink4, " +
                "MAX(CASE WHEN (mm.`week` = 5 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink5, " +
                "MAX(CASE WHEN (mm.`week` = 6 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink6, " +
                "MAX(CASE WHEN (mm.`week` = 7 AND mm.menuType = 3) THEN menuName ELSE '' END ) drink7 " +

                "FROM (SELECT " +
                "p.`name` AS personName," +
                "org.orgName AS orgName," +
                "info.personId AS personId," +
                "info.`week` AS `week`," +
                "info.type AS menuType," +
                "ord. NAME AS menuName" +
                " FROM person p");
        builder.append(" INNER JOIN organization org ON p.orgId = org.id");

        if (StringUtils.isNotBlank(MapUtils.getString(map, "orgId"))) {
            builder.append(" and p.orgId = #{orgId}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "personName"))) {
            builder.append(" and p.name = #{personName}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "personId"))) {
            builder.append(" and p.id = #{personId}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "orgName"))) {
            builder.append(" and org.orgName = #{orgName} ");
        }

        builder.append(" INNER JOIN orderInfo info ON p.id = info.personId ");
        builder.append(" INNER JOIN `order` ord ON info.orderId = ord.id and ord.logicalDel = 0");

        /*if (StringUtils.isNotBlank(MapUtils.getString(map, "logicalDel"))) {
            builder.append(" and ord.logicalDel = #{logicalDel} ");
        }*/

        builder.append(" ) AS mm GROUP BY mm.personName ORDER BY mm.personName DESC ");
        return builder.toString();
    }

    @Override
    protected String _query(Map map) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT * FROM orderInfo WHERE 1=1 ");
        if (StringUtils.isNotBlank(MapUtils.getString(map, "id"))) {
            builder.append(" and id = #{id}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "personId"))) {
            builder.append(" and personId = #{personId}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "orderId"))) {
            builder.append(" and orderId = #{orderId}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "week"))) {
            builder.append(" and week = #{week}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "type"))) {
            builder.append(" and type = #{type}");
        }
        if (StringUtils.isNotBlank(MapUtils.getString(map, "logicalDel"))) {
            builder.append(" and logicalDel = #{logicalDel} ");
        }
        return builder.toString();
    }

    public String clean(Map map) {
        return "";
    }


}
