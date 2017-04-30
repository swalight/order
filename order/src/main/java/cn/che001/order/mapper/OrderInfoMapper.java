package cn.che001.order.mapper;


import cn.che001.order.Dto.OrderInfoDto;
import cn.che001.order.domain.OrderInfoEntity;
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
@org.springframework.stereotype.Repository
public interface OrderInfoMapper extends BaseMapper {
    //------------------Add your code here---------------------

    //------------------以下代码自动生成-----------------------

    /**
     * @param orgId      机构Id
     * @param personName 姓名
     * @param orgName    机构名
     *                   //@param menuType 类型
     * @return
     */
    @SelectProvider(type = OrderInfoSql.class, method = "queryBreakfast")
    List<OrderInfoDto> queryBreakfast(@Param("orgId") String orgId,
                                      @Param("personName") String personName,
                                      @Param("personId") String personId,
                                      @Param("orgName") String orgName);

    /**
     * @param orgId      机构Id
     * @param personName 姓名
     * @param orgName    机构名
     *                   //@param menuType 类型
     * @return
     */
    @SelectProvider(type = OrderInfoSql.class, method = "queryLunch")
    List<OrderInfoDto> queryLunch(@Param("orgId") String orgId,
                                  @Param("personName") String personName,
                                  @Param("personId") String personId,
                                  @Param("orgName") String orgName);

    @SelectProvider(type = OrderInfoSql.class, method = "_queryAll")
    List<OrderInfoEntity> _queryAll(Map map);

    /**
     * 删除（逻辑）
     * 参数：
     * id ： 要删除的记录的id
     */
    @DeleteProvider(type = OrderInfoSql.class, method = "_delete")
    int _delete(String id);

    /**
     * 删除（物理）
     * 参数：
     * id ： 要删除的记录的id
     */
    @DeleteProvider(type = OrderInfoSql.class, method = "_deleteForce")
    int _deleteForce(String id);

    /**
     * 新增
     * 参数：
     * map里的key为属性名（字段首字母小写）
     * value为要插入的key值
     */
    @InsertProvider(type = OrderInfoSql.class, method = "_add")
    int _add(Map params);

    /**
     * 按实体类新增
     * 参数：
     * 实体类对象，必须有id属性
     */
    @InsertProvider(type = OrderInfoSql.class, method = "_addEntity")
    int _addEntity(OrderInfoEntity bean);

    /**
     * 更新
     * 参数：
     * id ： 要更新的记录的id
     * 其他map里的参数，key为属性名（字段首字母小写）
     * value为要更新成的值
     */
    @InsertProvider(type = OrderInfoSql.class, method = "_update")
    int _update(Map params);

    /**
     * 按实体类更新
     * 参数：
     * 实体类对象，必须有id属性
     */
    @InsertProvider(type = OrderInfoSql.class, method = "_updateEntity")
    int _updateEntity(OrderInfoEntity bean);

}