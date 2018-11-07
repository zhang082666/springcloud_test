package com.dj.cloud.client;

import com.dj.cloud.service.OrderService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "order-service")
public interface OrderServiceClient extends OrderService {
}
