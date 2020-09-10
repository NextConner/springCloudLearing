package com.zt.consumer.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zoujintao@daoran.tv
 * @Date: 2020/8/26 13:11
 */

@Configuration
public class FeignConfiguration {

    /**
     *  feign 日志配置类
     */
    @Bean
    Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }

    /**
     *  契约配置，使feign支持原生注解方式
     */
//    @Bean
//    public Contract feignContract(){
//        return new Contract.Default();
//    }

    /**
     *  基于feign的认证，请求过滤器
     * @return
     */
    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthenticationInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }

}
