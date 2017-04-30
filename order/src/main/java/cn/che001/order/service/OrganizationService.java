package cn.che001.order.service;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.OrganizationEntity;

/**
 * Created by 170246 on 2017/4/17.
 */
public interface OrganizationService {
    RestResult queryAll(OrganizationEntity entity);

    RestResult queryPage(OrganizationEntity entity);

    RestResult get(String id);

    RestResult add(OrganizationEntity entity);

    RestResult delete(String id);

    RestResult update(OrganizationEntity entity);

}
