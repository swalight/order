package cn.che001.order.service;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.TopEntity;

/**
 * Created by 170246 on 2017/4/18.
 */
public interface TopService {

    RestResult queryAll(TopEntity entity);

    RestResult get(String id);

    RestResult delete(String id);

    RestResult update(TopEntity entity);

    RestResult add(TopEntity entity);
}
