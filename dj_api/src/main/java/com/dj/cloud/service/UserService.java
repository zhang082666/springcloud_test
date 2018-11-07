package com.dj.cloud.service;


import com.dj.cloud.pojo.User;
import org.springframework.web.bind.annotation.*;

public interface UserService {

    @RequestMapping(value = "seyUser-api", method = RequestMethod.POST)
    String seyUser(@RequestParam("userName") String userName);

    @PostMapping("findUser")
    User findUser(@RequestBody User user);

}
