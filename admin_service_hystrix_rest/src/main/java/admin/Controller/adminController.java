package admin.Controller;


import admin.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admin")
/**
 * 指定统一的熔断设置，在@HystrixCommand不需要单独指定
 */
//@DefaultProperties(defaultFallback = "defaultfallback")
public class adminController {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "userfallback")
    //使用统一的降级方法不用带参数
    //@HystrixCommand
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getuser(@PathVariable int id){
        if (id!=1){
            throw new RuntimeException("服务器异常");
        }
        User user= restTemplate.getForObject("http://userservice/user/"+id,User.class);
        return user;
    }

    //降级方法，和需要受到保护的方法的返回值是一样的
    public User userfallback(int id){
        User user=new User();
        user.setUsername("触发降级");
        return user;
    }

    //指定统一的fallback方法，没有参数
    public User defaultfallback(){
        User user=new User();
        user.setUsername("触发降级");
        return user;
    }

}
