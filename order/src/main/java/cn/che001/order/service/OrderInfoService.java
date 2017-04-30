package cn.che001.order.service;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.OrderInfoEntity;
import cn.che001.order.utils.OrderType;

/**
 * Created by Swalight on 2017-04-17.
 */
public interface OrderInfoService {
    /**
     *
     * @param entity
     * @return
     */
    RestResult queryAll(OrderInfoEntity entity);

    /**
     *
     * @param entity
     * @return
     */
    RestResult queryPage(OrderInfoEntity entity);

    RestResult queryAllDto(String orgName, String personName,String personId, String orgId, OrderType type);

    RestResult queryPageDto(String orgName, String personName,String personId, String orgId, Integer currentPage, Integer pageSize, OrderType type);

    /**
     *
     * @param entity
     * @return
     */
    RestResult add(OrderInfoEntity entity);

    RestResult delete(String id);

    RestResult update(OrderInfoEntity entity);


}
