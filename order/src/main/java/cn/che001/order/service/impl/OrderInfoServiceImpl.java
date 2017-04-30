package cn.che001.order.service.impl;


import cn.che001.order.Base.PagerResult;
import cn.che001.order.Base.RestResult;
import cn.che001.order.Dto.OrderInfoDto;
import cn.che001.order.domain.OrderInfoEntity;
import cn.che001.order.mapper.OrderInfoMapper;
import cn.che001.order.service.OrderInfoService;
import cn.che001.order.utils.OrderType;
import cn.che001.order.utils.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by light on 2017/1/6.
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(OrderInfoService.class);
    @Autowired
    OrderInfoMapper mapper;

    /**
     * @param entity
     * @return
     */
    @Override
    public RestResult queryAll(OrderInfoEntity entity) {
        logger.info("there is queryAll params is orgId = {}, personName = {}, orderType = {}");
        List<OrderInfoEntity> list = mapper._queryAll(Utils.convertBeanToMap(entity));
        return Utils.successResult(new ArrayList<Object>());
    }

    /**
     * @param entity
     * @return
     */
    @Override
    public RestResult queryPage(OrderInfoEntity entity) {
        logger.info("there is queryPage params is orgId = {}, personName = {}, orderType = {}");
        PageHelper.startPage(entity.getCurrentPage(), entity.getPageSize());
        PageInfo pageInfo = new PageInfo(mapper._queryAll(Utils.convertBeanToMap(entity)));
        return new RestResult(RestResult.SUCCESS_CODE, RestResult.SUCCESS_MSG, new PagerResult(pageInfo));
    }

    @Override
    public RestResult queryAllDto(String orgName, String personName,String personId, String orgId, OrderType type) {
        List<OrderInfoDto> list = new ArrayList<OrderInfoDto>();
        switch (type) {
            case BREAKFAST:
                 list = mapper.queryBreakfast(orgId, personName,personId, orgName);
                break;
            case LUNCH:
                list = mapper.queryLunch(orgId,personName,personId,orgName);
                break;
            default:list = new ArrayList<OrderInfoDto>();
        }
        return Utils.successResult(list);
    }

    @Override
    public RestResult queryPageDto(String orgName, String personName,String personId,String orgId, Integer currentPage, Integer pageSize, OrderType type) {
        PageInfo info = null;
        switch (type){
            case BREAKFAST:
                PageHelper.startPage(currentPage,pageSize);
                info = new PageInfo(mapper.queryBreakfast(orgId, personName,personId, orgName));
                break;
            case LUNCH:
                PageHelper.startPage(currentPage,pageSize);
                info = new PageInfo(mapper.queryLunch(orgId, personName, personId,orgName));
        }
        RestResult restResult = new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG,new PagerResult(info));
        return restResult;
    }


    @Override
    public RestResult add(OrderInfoEntity entity) {
        logger.info("there is add method params is {}", entity.toString());
        entity.setId(UUID.randomUUID().toString());
        return Utils.restResultByRow(mapper._addEntity(entity));
    }

    @Override
    public RestResult delete(String id) {
        logger.info("there is delete method params is {}", id);
        return Utils.restResultByRow(mapper._deleteForce(id));
    }

    @Override
    public RestResult update(OrderInfoEntity entity) {
        logger.info("there is update method params is {}", entity.toString());
        return Utils.restResultByRow(mapper._updateEntity(entity));
    }
}
