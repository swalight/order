package cn.che001.order.service;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.PersonEntity;

public interface PersonService {
	RestResult get(String id);

	RestResult queryAll(PersonEntity entity);

	RestResult queryPage(PersonEntity entity);

	RestResult add(PersonEntity entity);

	RestResult delete(String id);

	RestResult update(PersonEntity entity);
}
