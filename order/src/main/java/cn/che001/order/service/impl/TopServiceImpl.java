package cn.che001.order.service.impl;


import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.TopEntity;
import cn.che001.order.mapper.TopMapper;
import cn.che001.order.service.TopService;
import cn.che001.order.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by light on 2017/4/19.
 */
@org.springframework.stereotype.Service
public class TopServiceImpl implements TopService{
    @Autowired
    TopMapper mapper;

    @Override
    public RestResult queryAll(TopEntity entity) {
        Map map = Utils.convertBeanToMap(entity);
        return Utils.successResult(mapper._queryAll(map));
    }

    @Override
    public RestResult get(String id) {
        return Utils.successResult(mapper._get(id));
    }

    @Override
    public RestResult delete(String id) {
        return Utils.restResultByRow(mapper._deleteForce(id));
    }

    @Override
    public RestResult update(TopEntity entity) {
        Map map = Utils.convertBeanToMap(entity);
        return Utils.restResultByRow(mapper._update(map));
    }

    @Override
    public RestResult add(TopEntity entity) {
        return null;
    }
}
