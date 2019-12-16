package com.sdxb.controller;

import com.sdxb.Mapper.UserMapper;
import com.sdxb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Value("${server.port}")
    private String port;//使用注解获取端口号
    @Value("${spring.cloud.client.ip-address}")
    private String ip;//使用注解获取ip地址


    @GetMapping("/{id}")
    public User user(@PathVariable("id") int id){
        User user = userMapper.selectbyid(id);
        user.setUsername(ip+":"+port);
        return user;
    }
}
