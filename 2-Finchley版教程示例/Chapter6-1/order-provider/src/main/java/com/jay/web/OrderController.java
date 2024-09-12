package com.jay.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * Created by xiang.wei on 2019/1/19
 *
 * @author xiang.wei
 */
@RestController
public class OrderController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc(HttpServletRequest request,String name) {
        String services = "hi: " +name+ ";port=" + request.getServerPort();
        return services;
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) throws InterruptedException {
//        让处理线程等待几分钟
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        String services = "Services: " + discoveryClient.getServices() + ";port=" + request.getServerPort();
        System.out.println(services);

        return "hello world";
    }

}
