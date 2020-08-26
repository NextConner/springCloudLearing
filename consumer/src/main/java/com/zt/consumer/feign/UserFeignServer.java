package com.zt.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client-user-provider:")
public interface UserFeignServer {

    @GetMapping("/v1/user/users")
    String users();

    @GetMapping("/v1/user/userAll")
    String usersNew();

}
