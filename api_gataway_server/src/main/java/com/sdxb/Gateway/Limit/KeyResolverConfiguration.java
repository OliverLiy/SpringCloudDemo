package com.sdxb.Gateway.Limit;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class KeyResolverConfiguration{
    /*
    *基于请求路径的限流
    */
    @Bean
    public KeyResolver pathKeyResolver(){
        //lambda表达式
        return exchange -> Mono.just(
                exchange.getRequest().getPath().toString()
        );
//      普通的java写法
//        return new KeyResolver() {
//            @Override
//            public Mono<String> resolve(ServerWebExchange exchange) {
//                return Mono.just(exchange.getRequest().getPath().toString());
//            }
//        };
    }
    /**
     * 基于请求ip的限流
     */
    @Bean
    public KeyResolver ipkeyResolver(){
        return exchange -> Mono.just(
                exchange.getRequest().getHeaders().getFirst("X-Forwarded-For")
        );
    }
    /**
     * 基于用户的限流
     */
    @Bean
    public KeyResolver userkeyResolver(){
        return exchange -> Mono.just(
                exchange.getRequest().getQueryParams().getFirst("user")
        );
    }
}
