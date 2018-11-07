package com.dj.cloud.service;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {

    @RequestMapping("seyUser-api")
    String seyUser(@RequestParam("userName") String userName);

}
