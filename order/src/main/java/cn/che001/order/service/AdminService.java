package cn.che001.order.service;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.AdminEntity;

/**
 * Created by 170246 on 2017/4/17.
 */
public interface AdminService {
    /**
     * 校验账号密码
     * @param entity
     * @return
     */
    RestResult checkAccount(AdminEntity entity);
}
