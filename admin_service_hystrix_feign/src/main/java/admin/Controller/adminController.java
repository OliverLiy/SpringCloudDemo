package admin.Controller;


import admin.Feign.UserFeignClient;
import admin.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class adminController {
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getuser(@PathVariable int id){
        User user= userFeignClient.findbyid(id);
        return user;
    }
}
