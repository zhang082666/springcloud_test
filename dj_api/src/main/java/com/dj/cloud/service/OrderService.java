package com.dj.cloud.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderService {

    @RequestMapping("sayOrder-api")
    String sayOrder(@RequestParam("userName") String userName);

}
