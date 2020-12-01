package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zoujintao@daoran.tv
 * @Date: 2020/8/20 10:41
 */
@Slf4j
@RestController
@RequestMapping("/v1/user/")
public class UserController {

    private static Map<String,String> users;
    static{
        users = new HashMap<>(8);
        for(int i=0;i<8;i++){
            users.put("user"+i,"testUserInfo"+i);
        }
    }


    @GetMapping("users")
    public String getUserList(){
        log.info("调用8092服务");
        return new JSONObject(users).toString();
    }

}
