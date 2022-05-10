package cn.ymxdy.springcachedemo;

import cn.ymxdy.springcachedemo.moudles.user.entity.UserEntity;
import cn.ymxdy.springcachedemo.moudles.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = SpringcacheDemoApplication.class)
class SpringcacheDemoApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<UserEntity> search = userService.search();
        System.out.println(search);
    }

}
