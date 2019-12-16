package admin.Feign;


import admin.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 声明需要调用的微服务名称
 *      name：服务名称
 *      fallback：降级处理方法
 */
@FeignClient(name = "userservice" , fallback = UserFeignClientFallBack.class)
public interface UserFeignClient {
    /**
     * 声明需要调用的微服务接口
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User findbyid(@PathVariable("id") int id);
}
