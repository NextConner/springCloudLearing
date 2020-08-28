package com.zt.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.omg.SendingContext.RunTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/hystrix/")
public class HystrixController {


    private static Map<String,Object> users = new HashMap<>(8);

    static {
        for(int i=0;i<8;i++){
            users.put("user:"+i, UUID.randomUUID());
        }
    }
    final String EXECUTION_TIMEOUT_ENABLED = "execution.timeout.enabled";
    final String EXECUTION_ISOLATION_THREAD_TIMEOUT="execution.isolation.thread.timeoutInMilliseconds";

    /**
     * 构建支持回退的userInfo
     */

    @GetMapping("userInfo")
    @HystrixCommand(fallbackMethod = "failUserInfo",
            commandProperties = {
            @HystrixProperty(name = EXECUTION_TIMEOUT_ENABLED,value = "true"),
            @HystrixProperty(name = EXECUTION_ISOLATION_THREAD_TIMEOUT,value = "3000")
            })
    public String userInfo()throws InterruptedException{
        Thread.sleep(3500);
        return users.toString();
    }

    private String failUserInfo(){
        return "fail to get users";
    }

}
