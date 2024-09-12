package com.jay.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod ="helloFallback" )
    public String getOrderService() {
        return restTemplate.getForObject("http://ORDER-SERVICE/dc",String.class);
    }


    /**
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallback",commandKey = "helloKey")
    public String getHelloService() {
        long startTime = System.currentTimeMillis();
        String result = restTemplate.getForObject("http://ORDER-SERVICE/hello", String.class);
        System.out.println("共花费的时间是={}" + (System.currentTimeMillis() - startTime) + "毫秒");
        return result;
    }
    /**
     * @return
     */
    public String helloFallback() {
        return "服务出现故障了";
    }

}
