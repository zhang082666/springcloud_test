package com.dj.cloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String seyUser(String userName) {
        return "hello User," + userName;
    }


}
