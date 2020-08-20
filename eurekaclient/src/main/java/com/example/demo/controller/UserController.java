package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zoujintao@daoran.tv
 * @Date: 2020/8/20 10:41
 */
@Slf4j
@RestController("/v1/user/")
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
        return users.toString();
    }

}