package com.zt.consumer.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/** 自定义的deign 请求认证授权处理器
 * @Author: zoujintao@daoran.tv
 * @Date: 2020/8/27 13:12
 */
@Configuration
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 定义请求认证的逻辑，例如获取请求头和body判断是否具备授权信息
    }
}
