package com.dj.cloud.web;

import com.dj.cloud.client.OrderServiceClient;
import com.dj.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderServiceClient orderService;

    @RequestMapping("seyUser")
    @ResponseBody
    public String seyUser(String userName){
        return userService.seyUser(userName);
    }

    @RequestMapping("seyUser1")
    @ResponseBody
    public String seyUser1(String userName){
        return orderService.sayOrder(userName);
    }

}
