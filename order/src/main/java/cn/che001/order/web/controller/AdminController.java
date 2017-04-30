package cn.che001.order.web.controller;

import cn.che001.order.Base.RestResult;
import cn.che001.order.domain.AdminEntity;
import cn.che001.order.service.AdminService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 170246 on 2017/4/18.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @ResponseBody
    @RequestMapping(value="/check", method = RequestMethod.POST)
    public RestResult check(HttpServletRequest request, @RequestBody String body) {
        Gson gson = new Gson();
        AdminEntity entity = gson.fromJson(body,AdminEntity.class);
        RestResult result = adminService.checkAccount(entity);
        return result;
    }
}
