package com.zt.consumer.interceptor;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URI;

public class MyLoadBalancerInterceptor implements ClientHttpRequestInterceptor {

    private LoadBalancerClient client;
    private LoadBalancerRequestFactory requestFactory;

    public MyLoadBalancerInterceptor(LoadBalancerClient client,LoadBalancerRequestFactory requestFactory){
        this.client=client;
        this.requestFactory=requestFactory;
        }

    public MyLoadBalancerInterceptor(LoadBalancerClient loadBalancer){
        this(loadBalancer,new LoadBalancerRequestFactory(loadBalancer));
    }

    public MyLoadBalancerInterceptor(){
    }


    @Override
    public ClientHttpResponse intercept(final HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        final URI originUri = httpRequest.getURI();
        String serviceName = originUri.getHost();
        System.out.println("进入自定义的拦截器中 :" + serviceName);
        Assert.state(serviceName!=null,"Request URI don`t contain a valid hostname :" + originUri);
        return this.client.execute(serviceName,requestFactory.createRequest(httpRequest,bytes,clientHttpRequestExecution));
    }


}
