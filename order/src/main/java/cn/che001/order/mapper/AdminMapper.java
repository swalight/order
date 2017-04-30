package cn.che001.order.mapper;

import cn.che001.order.domain.AdminEntity;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

/**
 * code generator by Shawn
 */
@MapperScan
public interface AdminMapper{
    //------------------Add your code here---------------------

    //------------------以下代码自动生成-----------------------

    /**
     * 根据条件查询全部
     * 参数：
     * map里的key为属性名（字段首字母小写）
     * value为查询的条件，默认为等于
     * 要改动sql请修改 *Mapper 类里的 _query() 方法
     */
    @SelectProvider(type = AdminSql.class,method = "_queryAll")
    List<AdminEntity> _queryAll(Map pagerParam);

    /**
     * 检验账号密码
     * @param account
     * @param password
     * @return
     */
    @SelectProvider(type = AdminSql.class,method = "check")
    List<AdminEntity> check(@Param("account") String account, @Param("password") String password);

    /**
     * 按id查询
     * 参数：
     * id ： 要查询的记录的id
     */
    @SelectProvider(type = AdminSql.class,method = "_get")
    AdminEntity _get(String id);

    /**
     * 删除（逻辑）
     * 参数：
     * id ： 要删除的记录的id
     */
    @DeleteProvider(type = AdminSql.class,method = "_delete")
    int _delete(String id);

    /**
     * 删除（物理）
     * 参数：
     * id ： 要删除的记录的id
     */
    @DeleteProvider(type = AdminSql.class,method = "_deleteForce")
    int _deleteForce(String id);

    /**
     * 新增
     * 参数：
     * map里的key为属性名（字段首字母小写）
     * value为要插入的key值
     */
    @InsertProvider(type = AdminSql.class,method = "_add")
    int _add(Map params);

    /**
     * 按实体类新增
     * 参数：
     * 实体类对象，必须有id属性
     */
    @InsertProvider(type = AdminSql.class,method = "_addEntity")
    int _addEntity(AdminEntity bean);

    /**
     * 更新
     * 参数：
     * id ： 要更新的记录的id
     * 其他map里的参数，key为属性名（字段首字母小写）
     * value为要更新成的值
     */
    @InsertProvider(type = AdminSql.class,method = "_update")
    int _update(Map params);

    /**
     * 按实体类更新
     * 参数：
     * 实体类对象，必须有id属性
     */
    @InsertProvider(type = AdminSql.class,method = "_updateEntity")
    int _updateEntity(AdminEntity bean);

}