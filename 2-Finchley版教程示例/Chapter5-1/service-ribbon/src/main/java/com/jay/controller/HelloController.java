package com.jay.controller;

import com.jay.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiang.wei on 2019/1/27
 *
 * @author xiang.wei
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/getOrderService")
    public String getOrderService() {
        return helloService.getOrderService();
    }

    @RequestMapping("getHelloService")
    public String getHelloService() {
        return helloService.getHelloService();
    }
}
