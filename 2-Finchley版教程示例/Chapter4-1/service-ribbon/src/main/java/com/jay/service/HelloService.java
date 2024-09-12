package com.jay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xiang.wei on 2019/1/27
 *
 * @author xiang.wei
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String getOrderService() {
        return restTemplate.getForObject("http://ORDER-SERVICE/dc",String.class);
    }
}
