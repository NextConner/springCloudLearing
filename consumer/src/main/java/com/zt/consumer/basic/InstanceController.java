package com.zt.consumer.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
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

    private static final  String EUREKA_SERVER = "http://eureka-server/";
    private static final  String EUREKA_SERVER_CLUSTER = "http://localhost:8762/eureka/apps/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    /**
     * 根据基于注册中心IP地址，根据服务名称检索服务实例
     */
    @RequestMapping(value = "{serviceName}")
    public String getInstance(@PathVariable String serviceName){
        return restTemplate.getForObject(EUREKA_SERVER+serviceName,String.class);
    }


    /**
     * 基于 DiscoveryClient 获取服务信息
     * @return
     */
    @Deprecated
    @RequestMapping(value = "/client/{serviceName}")
    public Object getServiceByClient(@PathVariable String serviceName){
        //禁用 eureka 之后无效
        return discoveryClient.getInstances(serviceName);
    }


    @RequestMapping()
    public String serviceList(){
        return restTemplate.getForObject(EUREKA_SERVER,String.class);
    }


    /**
     *  基于 loadBalancerClient 选择服务
     * @param serviceName
     * @return
     */
    @RequestMapping(value = "/loadBalance/{serviceName}")
    public Object getServiceByLoadBalance(@PathVariable String serviceName){
        return loadBalancerClient.choose(serviceName);
    }


}
