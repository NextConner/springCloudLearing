package com.zt.consumer.controller;

import com.zt.consumer.feign.UserFeignServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zoujintao@daoran.tv
 * @Date: 2020/8/21 12:38
 */
@Slf4j
@RestController
@RequestMapping("/c1/user/")
public class UserController {


    final String USER_SERVICE = "eureka-client-user-provider";

    @Autowired
    private RibbonLoadBalancerClient client;

    @Autowired
    private UserFeignServer userFeignServer;

    @GetMapping("users")
    public Object getUsers() {
        return client.choose(USER_SERVICE);

    }

    @GetMapping("allUser")
    public String getUsersByFeign() {
        return userFeignServer.users();
    }

    @GetMapping("/allUserNew")
    public String getAllUser() {
        return userFeignServer.users();
    }


}
