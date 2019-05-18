package cn.itqzing.hello.dubbo.service.user.consumer.controller;


import cn.itqzing.hello.dubbo.service.user.api.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Reference(version = "${user.service.version}")
    private UserService userService;
    @RequestMapping("hello")
    public String sayHello(){
        return userService.sayHello();
    }
}
