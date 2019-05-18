package cn.itqzing.hello.dubbo.service.user.provider.api.impl;

import cn.itqzing.hello.dubbo.service.user.api.UserService;
import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello() {
        return "hello dubbo";
    }
}
