package cn.ymxdy.springcachedemo;

import cn.ymxdy.springcachedemo.moudles.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootTest(classes = SpringcacheDemoApplication.class)
class SpringcacheDemoApplicationTests {
    @Autowired
    private UserService userService;

    /**
     * Java中自己带的定时任务
     */
    @Test
    void contextLoads() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 10);

    }

}
