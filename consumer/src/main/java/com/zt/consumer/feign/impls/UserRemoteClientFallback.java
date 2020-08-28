package com.zt.consumer.feign.impls;

import com.zt.consumer.feign.UserFeignServer;
import org.springframework.stereotype.Component;

@Component
public class UserRemoteClientFallback implements UserFeignServer {

    @Override
    public String users() {
        return "fallback call for users method!";
    }
}
