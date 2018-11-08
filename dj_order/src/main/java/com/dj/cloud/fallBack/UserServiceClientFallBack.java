package com.dj.cloud.fallBack;

import com.dj.cloud.client.UserServiceClient;
import com.dj.cloud.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceClientFallBack implements UserServiceClient {
    @Override
    public String seyUser(String userName) {
        return "传入参数为null，请注意参数是否传入";
    }

    @Override
    public User findUser(User user) {
        return null;
    }
}
