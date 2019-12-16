package admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan("com.sdxb.admin.entity")
@EnableEurekaClient
@EnableFeignClients
//激活hystrix
@EnableCircuitBreaker
//激活hytrix的web监控平台
@EnableHystrixDashboard
public class HyfeignAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(HyfeignAdminApplication.class,args);
    }
}
