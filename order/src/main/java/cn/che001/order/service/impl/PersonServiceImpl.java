package cn.che001.order.service.impl;


import cn.che001.order.Base.PagerResult;
import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.PersonEntity;
import cn.che001.order.mapper.PersonMapper;
import cn.che001.order.service.PersonService;
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
public class PersonServiceImpl implements PersonService{
    protected Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    PersonMapper mapper;

    @Override
    public RestResult get(String id) {
        return Utils.successResult(mapper._get(id));
    }

    @Override
    public RestResult queryAll(PersonEntity entity) {
        Map map = Utils.convertBeanToMap(entity);
        return Utils.successResult(mapper._queryAll(map));
    }

    @Override
    public RestResult queryPage(PersonEntity entity) {
        Map map = Utils.convertBeanToMap(entity);
        logger.info("there is queryPage, parameter is {} ",map.toString());
        PageHelper.startPage(entity.getCurrentPage(),entity.getPageSize());
        PageInfo pageInfo = new PageInfo(mapper._queryAll(map));
        return new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG,new PagerResult(pageInfo));
    }

    @Override
    public RestResult add(PersonEntity entity) {
        entity.setId(UUID.randomUUID().toString());
        logger.info("there is add, parameter is {} ",entity.toString());
        return Utils.restResultByRow(mapper._addEntity(entity));
    }

    @Override
    public RestResult delete(String id) {
        logger.info("there is delete, id is {} ",id);
        return Utils.restResultByRow(mapper._deleteForce(id));
    }

    @Override
    public RestResult update(PersonEntity entity) {
        logger.info("there is update, parameter is {} ",entity.toString());
        return Utils.restResultByRow(mapper._updateEntity(entity));
    }
}
