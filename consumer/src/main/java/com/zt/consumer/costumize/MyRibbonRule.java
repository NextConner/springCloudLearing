package com.zt.consumer.costumize;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 简单实现自定义的负载均衡类
 * @Author: zoujintao@daoran.tv
 * @Date: 2020/8/25 13:19
 */
public class MyRibbonRule  implements IRule {
    private ILoadBalancer lb;


    /**
     *  策略生效逻辑再在于choose 方法如何选择服务，这里从8092,8094中选择每次都是用8094端口提供服务
     * @param key
     * @return
     */
    @Override
    public Server choose(Object key) {
        List<Server> serveList = lb.getAllServers();
        for(Server server  : serveList){
            System.out.println("服务信息 : " + server.getId());
            if(server.getPort() == 8094){
                return server;
            }
        }
        return serveList.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
