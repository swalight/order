package cn.che001.order.Base;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.UUID;

public abstract class BaseProvider {
    public BaseProvider() {
    }

    protected abstract String getTableName();

    protected abstract String[] getColumns();

    protected abstract String _query(Map var1);

    public String _queryAll(Map param) {
        return this._query(param);
    }

    public String _get(String id) {
        StringBuilder builder = (new StringBuilder("select * from ")).append(this.getTableName()).append(" where Id=#{id} and LogicalDel=0 ");
        return builder.toString();
    }

    public String _getAll() {
        StringBuilder builder = (new StringBuilder("select * from ")).append(this.getTableName()).append(" where LogicalDel=0");
        return builder.toString();
    }

    public String _deleteForce(String id) {
        StringBuilder builder = (new StringBuilder("delete from ")).append(this.getTableName()).append(" where Id=#{id}");
        return builder.toString();
    }

    public String _delete(String id) {
        StringBuilder builder = (new StringBuilder("update ")).append(this.getTableName()).append(" set LogicalDel=1 where Id=#{id}");
        return builder.toString();
    }

    public String _add(Map map) {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        String[] var5 = this.getColumns();
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String c = var5[var7];
            if(map.get(StringUtils.uncapitalize(c)) != null) {
                builder1.append(",").append("`").append(c).append("`");
                builder2.append(",#{" + StringUtils.uncapitalize(c) + "}");
            }
        }

        builder.append("insert into ").append(this.getTableName());
        builder.append("(");
        builder.append("Id,LogicalDel,CreateTime,UpdateTime");
        builder.append(builder1);
        builder.append(")");
        builder.append("values");
        builder.append("(\'");
        builder.append(MapUtils.getString(map, "id", UUID.randomUUID().toString()) + "\'," + MapUtils.getInteger(map, "logicalDel", Integer.valueOf(0)) + "," + ",now(),now()");
        builder.append(builder2);
        builder.append(")");
        return builder.toString();
    }

    public String _update(Map map) {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        String[] var4 = this.getColumns();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String c = var4[var6];
            if(map.get(StringUtils.uncapitalize(c)) != null) {
                builder1.append(",").append("`").append(c).append("`").append("=#{" + StringUtils.uncapitalize(c) + "}");
            }
        }

        builder.append("update ").append(this.getTableName());
        builder.append(builder1);
        builder.append(" where Id=#{id}");
        return builder.toString();
    }

    public String _addEntity(Object bean) {
        try {
            return this._add(BeanUtils.describe(bean));
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public String _updateEntity(Object bean) {
        try {
            return this._update(BeanUtils.describe(bean));
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }
}