package cn.itqzing.hello.dubbo.service.user.consumer.controller;


import cn.itqzing.hello.dubbo.service.user.api.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Reference(version = "${user.service.version}")
    private UserService userService;
    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping("hello")
    public String sayHello(){
        return userService.sayHello();
    }
    public String hiError() {
        return "Hystrix fallback!";
    }
}
