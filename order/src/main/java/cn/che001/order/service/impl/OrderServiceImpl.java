package cn.che001.order.service.impl;


import cn.che001.order.Base.PagerResult;
import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.OrderEntity;
import cn.che001.order.mapper.OrderMapper;
import cn.che001.order.service.OrderService;
import cn.che001.order.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.UUID;

/**
 * Created by light on 2017/1/6.
 */
@org.springframework.stereotype.Service
public class OrderServiceImpl implements OrderService{
    protected static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderMapper mapper;

    @Override
    public RestResult get(String id) {
        return Utils.successResult(mapper._get(id));
    }

    @Override
    public RestResult queryAll(OrderEntity entity) {
        Map map = Utils.convertBeanToMap(entity);
        return new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG,mapper._queryAll(map));
    }

    @Override
    public RestResult queryPage(OrderEntity entity) {
        Map map = Utils.convertBeanToMap(entity);
        PageHelper.startPage(entity.getCurrentPage(),entity.getPageSize());
        PageInfo pageInfo = new PageInfo(mapper._queryAll(map));
        return new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG,new PagerResult(pageInfo));
    }

    @Override
    public RestResult add(OrderEntity entity) {
        entity.setId(UUID.randomUUID().toString());
        logger.info("there is add method, parameter is {}",entity.toString());
        return new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG,mapper._addEntity(entity));
    }

    @Override
    public RestResult deleteForce(String id) {
        logger.info("there is deleteForce method, id is {}",id);
        int i = mapper._deleteForce(id);
        return Utils.restResultByRow(i);
    }

    @Override
    public RestResult delete(String id) {
        logger.info("there is delete method, id is {}",id);
        int i = mapper._delete(id);
        return Utils.restResultByRow(i);
    }

    @Override
    public RestResult recover(String id) {
        logger.info("there is delete method, id is {}",id);
        int i = mapper.recover(id);
        return Utils.restResultByRow(i);
    }

    @Override
    public RestResult update(OrderEntity entity) {
        logger.info("there is update method, parameter is {}",entity.toString());
        return Utils.restResultByRow(mapper._updateEntity(entity));
    }
}
