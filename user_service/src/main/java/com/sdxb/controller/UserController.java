package com.sdxb.controller;

import com.sdxb.Mapper.UserMapper;
import com.sdxb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/{id}")
    public User user(@PathVariable("id") int id){
        User users = userMapper.selectbyid(id);
        return users;
    }
}
