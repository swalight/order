package cn.che001.order.mapper;


import cn.che001.order.domain.PersonEntity;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

/**
 * code generator by Shawn
 */
@MapperScan
@org.springframework.stereotype.Repository
public interface PersonMapper extends BaseMapper{
    //------------------Add your code here---------------------

    //------------------以下代码自动生成-----------------------

    /**
     * 根据条件查询全部
     * 参数：
     * map里的key为属性名（字段首字母小写）
     * value为查询的条件，默认为等于
     * 要改动sql请修改 *Mapper 类里的 _query() 方法
     */
    @SelectProvider(type = PersonSql.class,method = "_queryAll")
    List<PersonEntity> _queryAll(Map pagerParam);

    /**
     * 按id查询
     * 参数：
     * id ： 要查询的记录的id
     */
    @SelectProvider(type = PersonSql.class,method = "_get")
    PersonEntity _get(String id);

    @SelectProvider(type = PersonSql.class,method = "_get")
    PersonEntity getByName(String name);

    /**
     * 删除（逻辑）
     * 参数：
     * id ： 要删除的记录的id
     */
    @DeleteProvider(type = PersonSql.class,method = "_delete")
    int _delete(String id);

    /**
     * 删除（物理）
     * 参数：
     * id ： 要删除的记录的id
     */
    @DeleteProvider(type = PersonSql.class,method = "_deleteForce")
    int _deleteForce(String id);

    /**
     * 新增
     * 参数：
     * map里的key为属性名（字段首字母小写）
     * value为要插入的key值
     */
    @InsertProvider(type = PersonSql.class,method = "_add")
    int _add(Map params);

    /**
     * 按实体类新增
     * 参数：
     * 实体类对象，必须有id属性
     */
    @InsertProvider(type = PersonSql.class,method = "_addEntity")
    int _addEntity(PersonEntity bean);

    /**
     * 更新
     * 参数：
     * id ： 要更新的记录的id
     * 其他map里的参数，key为属性名（字段首字母小写）
     * value为要更新成的值
     */
    @InsertProvider(type = PersonSql.class,method = "_update")
    int _update(Map params);

    /**
     * 按实体类更新
     * 参数：
     * 实体类对象，必须有id属性
     */
    @InsertProvider(type = PersonSql.class,method = "_updateEntity")
    int _updateEntity(PersonEntity bean);



}