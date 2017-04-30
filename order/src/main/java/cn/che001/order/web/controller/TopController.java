package cn.che001.order.web.controller;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.TopEntity;
import cn.che001.order.service.TopService;
import cn.che001.order.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 170246 on 2017/4/18.
 */
@RestController
@RequestMapping("/top")
public class TopController {
    private static Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    TopService topService;

    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public RestResult queryAll(HttpServletRequest request, HttpServletResponse response){
        TopEntity entity = new TopEntity();
        HttpUtils.request2Bean(entity,request,null);
        logger.info("queryAll params = {}",entity.toString());
        return topService.queryAll(entity);
    }
}
