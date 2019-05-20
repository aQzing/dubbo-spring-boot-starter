package cn.itqzing.hello.dubbo.service.user.provider.api.impl;

import cn.itqzing.hello.dubbo.service.user.api.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {
    @Value("${dubbo.protocol.port}")
    private int port ;
    @Override
    public String sayHello() {
        return "hello dubbo,i am form port :"+port;
    }
}
