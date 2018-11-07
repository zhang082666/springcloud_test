package com.dj.cloud.web;

import com.dj.cloud.client.UserServiceClient;
import com.dj.cloud.pojo.User;
import com.dj.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Autowired
    private UserServiceClient userService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("sayOrder")
    @ResponseBody
    public String sayOrder(String userName){
        return userService.seyUser(userName);
    }

    @RequestMapping("sayOrder1")
    @ResponseBody
    public String sayOrder1(String userName){
        return orderService.sayOrder(userName);
    }

    @RequestMapping(value = "findUserByOrderFunction", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User findUserByOrderFunction(User user){
        return userService.findUser(user);
    }

}
