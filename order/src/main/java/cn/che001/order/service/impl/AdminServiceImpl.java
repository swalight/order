package cn.che001.order.service.impl;


import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.AdminEntity;
import cn.che001.order.mapper.AdminMapper;
import cn.che001.order.service.AdminService;
import cn.che001.order.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by light on 2017/1/6.
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper mapper;

    /**
     * 校验账号密码
     * @param entity
     * @return
     */
    @Override
    public RestResult checkAccount(AdminEntity entity) {
        List list = mapper.check(entity.getAccount(),entity.getPassword());
        RestResult restResult = list.size()>0?new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG):
                new RestResult(Constants.FORBADE,Constants.KEYWRONGMSG);
        return restResult;
    }
}
