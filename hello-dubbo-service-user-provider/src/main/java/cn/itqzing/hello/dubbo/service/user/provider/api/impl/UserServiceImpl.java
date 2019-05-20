package cn.itqzing.hello.dubbo.service.user.provider.api.impl;

import cn.itqzing.hello.dubbo.service.user.api.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {
    @Value("${dubbo.protocol.port}")
    private int port ;
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @Override
    public String sayHello() {
        //return "hello dubbo,i am form port :"+port;
        throw new RuntimeException("Exception to show hystrix enabled.");
    }
}
