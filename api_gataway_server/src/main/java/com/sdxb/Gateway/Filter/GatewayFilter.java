package com.sdxb.Gateway.Filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GatewayFilter implements GlobalFilter, Ordered {
    //在里面写过滤器的逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入了过滤器");
        //用户验证过滤器
//        String token = exchange.getRequest().getQueryParams().getFirst("access-token");
//        if (token==null){
//            //如果不存在，认证失败
//            System.out.println("没有登陆");
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
        return chain.filter(exchange);
    }
    //过滤器的优先级，数值越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
