package cn.che001.order.web.controller;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.OrganizationEntity;
import cn.che001.order.service.OrganizationService;
import cn.che001.order.utils.Constants;
import cn.che001.order.utils.HttpUtils;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 170246 on 2017/4/18.
 */
@RequestMapping("/organization")
public class OrganizationController {
    private static Logger logger = LoggerFactory.getLogger(OrganizationController.class);
    @Autowired
    OrganizationService organizationService;

    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public RestResult queryAll(HttpServletRequest request, HttpServletResponse response){
        OrganizationEntity entity = new OrganizationEntity();
        HttpUtils.request2Bean(entity,request,null);
        logger.info("queryAll params = {}",entity.toString());
        return organizationService.queryAll(entity);
    }

    @RequestMapping(value = "/queryPage",method = RequestMethod.GET)
    public RestResult queryPage(HttpServletRequest request, HttpServletResponse response){
        OrganizationEntity entity = new OrganizationEntity();
        HttpUtils.request2Bean(entity,request,null);
        logger.info("queryPage params = {}",entity.toString());
        return organizationService.queryPage(entity);
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public RestResult get(HttpServletRequest request, HttpServletResponse response){
        OrganizationEntity entity = new OrganizationEntity();
        HttpUtils.request2Bean(entity,request,null);
        logger.info("get id = {}",entity.getId());
        if(Strings.isNullOrEmpty(String.valueOf(entity.getId()))){
            return new RestResult(Constants.PARAMSNULL,"id is null");
        }
        return organizationService.get(String.valueOf(entity.getId()));
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.PUT)
    public RestResult delete(HttpServletResponse response,@PathVariable("id") String id){
        logger.info("delete id = {}",id);
        return organizationService.delete(id);
    }

    @RequestMapping(value = "/deleteForce/{id}",method = RequestMethod.PUT)
    public RestResult deleteForce(HttpServletResponse response, @PathVariable("id") String id){
        logger.info("delete id = {}",id);
        return organizationService.delete(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RestResult add(HttpServletRequest request, @RequestBody String body) {
        Gson gson = new Gson();
        OrganizationEntity entity = gson.fromJson(body,OrganizationEntity.class);
        logger.info("add entity = {}",entity.toString());
        return organizationService.add(entity);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RestResult update(HttpServletRequest request, @RequestBody String body) {
        Gson gson = new Gson();
        OrganizationEntity entity = gson.fromJson(body,OrganizationEntity.class);
        logger.info("update entity = {}",entity.toString());
        if(Strings.isNullOrEmpty(String.valueOf(entity.getId()))){
            return new RestResult(Constants.PARAMSNULL,"id is null");
        }
        return organizationService.update(entity);
    }
}
