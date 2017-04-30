package cn.che001.order.web.controller;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.OrderEntity;
import cn.che001.order.service.OrderService;
import cn.che001.order.utils.Constants;
import cn.che001.order.utils.HttpUtils;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 170246 on 2017/4/18.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public RestResult queryAll(HttpServletRequest request, HttpServletResponse response){
        OrderEntity entity = new OrderEntity();
        HttpUtils.request2Bean(entity,request,null);
        logger.info("queryAll params = {}",entity.toString());
        return orderService.queryAll(entity);
    }

    @RequestMapping(value = "/queryPage",method = RequestMethod.GET)
    public RestResult queryPage(HttpServletRequest request, HttpServletResponse response){
        OrderEntity entity = new OrderEntity();
        HttpUtils.request2Bean(entity,request,null);
        logger.info("queryPage params = {}",entity.toString());
        return orderService.queryPage(entity);
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public RestResult get(HttpServletRequest request, HttpServletResponse response){
        OrderEntity entity = new OrderEntity();
        HttpUtils.request2Bean(entity,request,null);
        logger.info("get id = {}",entity.getId());
        if(Strings.isNullOrEmpty(String.valueOf(entity.getId()))){
            return new RestResult(Constants.PARAMSNULL,"id is null");
        }
        return orderService.get(String.valueOf(entity.getId()));
    }

    @RequestMapping(value = "/remove/{id}",method = RequestMethod.PUT)
    public RestResult logicalDelete(HttpServletResponse response,@PathVariable("id") String id){
        logger.info("delete id = {}",id);
        return orderService.delete(id);
    }

    @RequestMapping(value = "/deleteForce/{id}",method = RequestMethod.PUT)
    public RestResult deleteForce(HttpServletResponse response,@PathVariable("id") String id){
        logger.info("delete id = {}",id);
        return orderService.deleteForce(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RestResult add(HttpServletRequest request, @RequestBody String body) {
        Gson gson = new Gson();
        OrderEntity entity = gson.fromJson(body,OrderEntity.class);
        logger.info("add entity = {}",entity.toString());
        return orderService.add(entity);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RestResult update(HttpServletRequest request, @RequestBody String body) {
        Gson gson = new Gson();
        OrderEntity entity = gson.fromJson(body,OrderEntity.class);
        logger.info("update entity = {}",entity.toString());
        if(Strings.isNullOrEmpty(String.valueOf(entity.getId()))){
            return new RestResult(Constants.PARAMSNULL,"id is null");
        }
        return orderService.update(entity);
    }
}
