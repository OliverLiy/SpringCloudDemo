package com.sdxb.admin.Controller;

import com.sdxb.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getuser(@PathVariable int id){
        User user= restTemplate.getForObject("http://127.0.0.1:9001/user/1",User.class);
        return user;
    }
}
