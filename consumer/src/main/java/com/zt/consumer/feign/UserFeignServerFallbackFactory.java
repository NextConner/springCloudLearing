package com.zt.consumer.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFeignServerFallbackFactory implements FallbackFactory<UserFeignServer> {

    @Override
    public UserFeignServer create(Throwable throwable) {
        log.error("{}调用回退:{}",this.getClass().getSimpleName(),throwable);
        return new UserFeignServer() {
            @Override
            public String users() {
                return "users feign call fallback!";
            }
        };
    }

}
