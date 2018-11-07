package com.dj.cloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public String sayOrder(String userName) {
        return "hello Order,"+userName;
    }



}
