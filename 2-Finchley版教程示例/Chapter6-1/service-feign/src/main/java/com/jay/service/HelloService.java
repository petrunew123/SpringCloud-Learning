package com.jay.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiang.wei on 2019/2/14
 *
 * @author xiang.wei
 */
//指定调用的服务
@FeignClient(serviceId = "order-service")
public interface HelloService {

    @GetMapping(value = "/dc")
    String getOrderService(@RequestParam("name") String name);

}
