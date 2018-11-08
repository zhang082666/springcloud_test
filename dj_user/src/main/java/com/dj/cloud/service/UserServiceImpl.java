package com.dj.cloud.service;

import com.dj.cloud.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String seyUser(String userName) {

        if(!StringUtils.isEmpty(userName)){
            return "hello User," + userName;
        }

        throw new RuntimeException();
    }

    @Override
    public User findUser(@RequestBody User user) {
        return user;
    }


}
