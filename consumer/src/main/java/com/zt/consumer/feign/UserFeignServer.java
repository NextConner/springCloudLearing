package com.zt.consumer.feign;

import com.zt.consumer.feign.impls.UserRemoteClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// 使用 fallback 类实现接口的所有方法，在具体方法fallback的时候进行调用
//@FeignClient(value = "eureka-client-user-provider:",fallback = UserRemoteClientFallback.class)
// 或者使用fallbackFactory 可以获得具体方回退的异常信息，但是实现方式不优雅
@FeignClient(value = "eureka-client-user-provider:",fallbackFactory = UserFeignServerFallbackFactory.class)
public interface UserFeignServer {

    @GetMapping("/v1/user/users")
    String users();

}
