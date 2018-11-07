package com.dj.cloud.client;

import com.dj.cloud.service.UserService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "user-service")
public interface UserServiceClient extends UserService {
}
