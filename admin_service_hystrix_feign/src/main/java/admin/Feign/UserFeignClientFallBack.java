package admin.Feign;

import admin.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallBack implements UserFeignClient {
    @Override
    public User findbyid(int id) {
        User user=new User();
        user.setUsername("使用feign降级处理");
        return user;
    }
}
