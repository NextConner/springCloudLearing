package com.ZT.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class IPFilter extends ZuulFilter {

    //自定义黑名单
    private List<String> blackList = Arrays.asList("127.0.0.1");


    // 过滤器类型,pre,route ,error,post
    @Override
    public String filterType() {
        return null;
    }

    // 过滤的执行顺序，数值越小，优先级越高
    @Override
    public int filterOrder() {
        return 0;
    }

    // 是否需要执行此过滤器 , 在配置文件中通过zuul.{filterName}.{filterType}.disable=true/false 动态控制
    @Override
    public boolean shouldFilter() {
        return false;
    }

    // 当前过滤器的逻辑
    @Override
    public Object run() throws ZuulException{

        RequestContext ctx = RequestContext.getCurrentContext();
        String ip = ctx.getRouteHost().getHost();
        if(StringUtils.isNotBlank(ip) && blackList.contains(ip)){
            ctx.setSendZuulResponse(false);
            JSONObject  json = new JSONObject();
            try {
                json.put("msg","非法请求!");
                ctx.setResponseBody(json.toString());
                ctx.getResponse().setContentType("application/json;charset=utf-8");
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
