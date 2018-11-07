package com.dj.cloud.service;

import com.dj.cloud.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String seyUser(String userName) {
        return "hello User," + userName;
    }

    @Override
    public User findUser(@RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        return user;
    }


}
