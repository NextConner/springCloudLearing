package com.zt.consumer.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zoujintao@daoran.tv
 * @Date: 2020/8/21 18:05
 */
@Slf4j
@RestController
@RequestMapping("/v1/instance/")
public class InstanceController {

    private static final  String EUREKA_SERVER = "http://localhost:8761/eureka/apps/";
    private static final  String EUREKA_SERVER_CLUSTER = "http://localhost:8762/eureka/apps/";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据服务名称检索服务实例
     */
    @RequestMapping(value = "{serviceName}")
    public String getInstance(@PathVariable String serviceName){
        return restTemplate.getForObject(EUREKA_SERVER+serviceName,String.class);
    }

    @RequestMapping()
    public String serviceList(){
        return restTemplate.getForObject(EUREKA_SERVER,String.class);
    }

}
