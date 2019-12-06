package com.sdxb.admin.Controller;

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
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getuser(@PathVariable int id){
        //修改前通过url调用微服务
        //User user= restTemplate.getForObject("http://127.0.0.1:9001/user/1",User.class);
        List<ServiceInstance> instances = discoveryClient.getInstances("user_service");
        ServiceInstance serviceInstance = instances.get(0);
        User user= restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()
                +"/user/1",User.class);
        return user;
    }
}
