package cn.che001.order.web.controller;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.OrderInfoEntity;
import cn.che001.order.service.OrderInfoService;
import cn.che001.order.utils.Constants;
import cn.che001.order.utils.HttpUtils;
import cn.che001.order.utils.OrderType;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by 170246 on 2017/4/21.
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {
    private static Logger logger = LoggerFactory.getLogger(OrderInfoController.class);
    @Autowired
    OrderInfoService orderInfoService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public RestResult getAll(HttpServletRequest request, HttpServletResponse response){
        OrderInfoEntity entity = new OrderInfoEntity();
        HttpUtils.request2Bean(entity,request,null);
        logger.info("queryAll params = {}",entity.toString());
        return orderInfoService.queryAll(entity);
    }

    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public RestResult queryAll(HttpServletRequest request, HttpServletResponse response){
        Map<String,String[]> map = request.getParameterMap();
        String orgId = null;
        String personId = null;
        String personName = null;
        String orgName = null;
        String type = null;
        if(map.containsKey("orgId")){orgId = map.get("orgId")[0];}
        if(map.containsKey("personId")){personId = map.get("personId")[0];}
        if(map.containsKey("personName")){personName = map.get("personName")[0];}
        if(map.containsKey("orgName")){orgName = map.get("orgName")[0];}
        if(map.containsKey("type")){type = map.get("type")[0];}
        logger.info("queryAll params orgId = {}, personId = {}, orgName = {}, type = {}",orgId,personId,orgName,type);
        OrderType orderType = null;
        if(type.equalsIgnoreCase("BREAKFAST")){
            orderType = OrderType.BREAKFAST;
        }
        if(type.equalsIgnoreCase("LUNCH")){
            orderType = OrderType.LUNCH;
        }
        return orderInfoService.queryAllDto(orgName,personName,personId,orgId,orderType);
    }

    @RequestMapping(value = "/queryPage",method = RequestMethod.GET)
    public RestResult queryPage(HttpServletRequest request, HttpServletResponse response){
        Map<String,String[]> map = request.getParameterMap();
        String orgId = null;
        String personId = null;
        String personName = null;
        String orgName = null;
        String type = null;
        Integer currentPage = 1;
        Integer pageSize = 10;
        if(map.containsKey("orgId")){orgId = map.get("orgId")[0];}
        if(map.containsKey("personId")){personId = map.get("personId")[0];}
        if(map.containsKey("personName")){personName = map.get("personName")[0];}
        if(map.containsKey("orgName")){orgName = map.get("orgName")[0];}
        if(map.containsKey("type")){type = map.get("type")[0];}
        if(map.containsKey("currentPage")){currentPage = Integer.parseInt(map.get("currentPage")[0]);}
        if(map.containsKey("pageSize")){pageSize = Integer.parseInt(map.get("pageSize")[0]);}
        logger.info("queryAll params orgId = {}, personId = {}, orgName = {}, type = {}, currentPage = {}, pageSize = {}",orgId,personId,orgName,type,currentPage,pageSize);
        OrderType orderType = null;
        if(type.equalsIgnoreCase("BREAKFAST")){
            orderType = OrderType.BREAKFAST;
        }
        if(type.equalsIgnoreCase("LUNCH")){
            orderType = OrderType.LUNCH;
        }
        return orderInfoService.queryPageDto(orgName,personName,personId,orgId,currentPage,pageSize,orderType);
    }

    @RequestMapping(value = "/deleteForce/{id}",method = RequestMethod.PUT)
    public RestResult deleteForce(HttpServletResponse response, @PathVariable("id") String id){
        logger.info("delete id = {}",id);
        return orderInfoService.delete(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RestResult add(HttpServletRequest request, @RequestBody String body) {
        Gson gson = new Gson();
        OrderInfoEntity entity = gson.fromJson(body,OrderInfoEntity.class);
        logger.info("add entity = {}",entity.toString());
        return orderInfoService.add(entity);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RestResult update(HttpServletRequest request, @RequestBody String body) {
        Gson gson = new Gson();
        OrderInfoEntity entity = gson.fromJson(body,OrderInfoEntity.class);
        logger.info("update entity = {}",entity.toString());
        if(Strings.isNullOrEmpty(String.valueOf(entity.getId()))){
            return new RestResult(Constants.PARAMSNULL,"id is null");
        }
        return orderInfoService.update(entity);
    }
}
