package cn.che001.order.service;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.OrderEntity;

/**
 * Created by 170246 on 2017/4/17.
 */
public interface OrderService {

    RestResult get(String id);

    RestResult queryAll(OrderEntity entity);

    RestResult queryPage(OrderEntity entity);

    /**
     * 添加
     * @param entity
     * @return
     */
    RestResult add(OrderEntity entity);

    /**
     * 物理删除
     * @param id
     * @return
     */
    RestResult deleteForce(String id);

    /**
     * 逻辑删除
     * @param id
     * @return
     */
    RestResult delete(String id);

    /**
     * 恢复删除
     * @param id
     * @return
     */
    RestResult recover(String id);

    /**
     * 更新
     * @param entity
     * @return
     */
    RestResult update(OrderEntity entity);

}
