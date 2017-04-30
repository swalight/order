package cn.che001.order.service.impl;


import cn.che001.order.Base.PagerResult;
import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.OrganizationEntity;
import cn.che001.order.mapper.OrganizationMapper;
import cn.che001.order.service.OrganizationService;
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
public class OrganizationServiceImpl implements OrganizationService {
    protected static Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    @Autowired
    OrganizationMapper mapper;

    @Override
    public RestResult queryAll(OrganizationEntity entity) {
        Map map = Utils.convertBeanToMap(entity);
        RestResult restResult = new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG,mapper._queryAll(map));
        return restResult;
    }

    @Override
    public RestResult queryPage(OrganizationEntity entity) {
        Map map = Utils.convertBeanToMap(entity);
        PageHelper.startPage(entity.getCurrentPage(),entity.getPageSize());
        PageInfo pageInfo = new PageInfo(mapper._queryAll(map));
        return new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG, new PagerResult(pageInfo));
    }

    @Override
    public RestResult get(String id) {
        logger.info("there is get method, id is {}",id);
        return new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG,mapper._get(id));
    }

    @Override
    public RestResult add(OrganizationEntity entity) {
        entity.setId(UUID.randomUUID().toString());
        logger.info("there is add method, parameter is {}",entity.toString());
        return Utils.restResultByRow(mapper._addEntity(entity));
    }

    @Override
    public RestResult delete(String id) {
        logger.info("there is delete method, id is {}",id);
        return Utils.restResultByRow(mapper._deleteForce(id));
    }

    @Override
    public RestResult update(OrganizationEntity entity) {
        logger.info("there is update method, parameter is {}",entity.toString());
        return Utils.restResultByRow(mapper._updateEntity(entity));
    }
}
