package com.jay.controller;

import com.jay.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiang.wei on 2019/2/14
 *
 * @author xiang.wei
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/dc")
    public String getOrderService(String name) {
        return helloService.getOrderService(name);
    }
}
