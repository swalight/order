package cn.che001.order.web.controller;

import cn.che001.order.Base.RestResult;
import cn.che001.order.xml.LockSwitchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Swalight on 2017-04-21.
 */
@RestController
@RequestMapping("/lock")
public class LockController {
    private static Logger logger = LoggerFactory.getLogger(LockController.class);
    @Autowired
    LockSwitchService lockSwitchService;

    @RequestMapping(value = "/update/{status}",method = RequestMethod.PUT)
    public RestResult logicalDelete(HttpServletResponse response, @PathVariable("status") String status){
        logger.info("update status = {}",status);
        RestResult restResult = lockSwitchService.updateLock(status)==true?new RestResult(RestResult.SUCCESS_CODE,RestResult.SUCCESS_MSG):
                new RestResult(RestResult.ERROR_CODE,RestResult.ERROR_MSG);
        return restResult;
    }
}
