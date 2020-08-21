package com.zt.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("users")
    public String getUsers(){
        return restTemplate.getForObject("http://eureka-client-user-provider/v1/user/users",String.class);
    }


}
