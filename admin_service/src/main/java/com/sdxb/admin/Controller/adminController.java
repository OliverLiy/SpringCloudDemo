package com.sdxb.admin.Controller;

import com.sdxb.admin.Feign.UserFeignClient;
import com.sdxb.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class adminController {
    @Autowired
    private UserFeignClient userFeignClient;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getuser(@PathVariable int id){
        //使用feign远程调用
        User user= userFeignClient.findbyid(id);
        return user;
    }
}
