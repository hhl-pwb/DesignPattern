package com.atguigu.decoratormode.service.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 为了实现多层装饰，定义了一个新的装饰者类，它同时持有日志装饰者和权限装饰者的引用，并在构造方法中引入他们
@Service("logAndAuthUser") //@Service注解表示这是一个service层的bean
public class LogAndAuthUserServiceDecorator extends UserServiceDecorator {

    // 日志装饰者
    private LogUserServiceDecorator logUserServiceDecorator;

    // 权限装饰者
    private AuthUserServiceDecorator authUserServiceDecorator;

    // 通过构造方法日志日志装饰者和权限装饰者，并且使用@Autowired主键让SpringBoot自动为我们选择合适的bean对象
    @Autowired
    public LogAndAuthUserServiceDecorator(AuthUserServiceDecorator authUserServiceDecorator, LogUserServiceDecorator logUserServiceDecorator) {
        // 调用父类的构造方法，传入任意一个被装饰的对象，这里我们传入日志装饰者
        super(logUserServiceDecorator);
        // 赋值日志装饰者和权限装饰者的引用
        this.logUserServiceDecorator = logUserServiceDecorator;
        this.authUserServiceDecorator = authUserServiceDecorator;

    }

    // 在原有的service的基础上添加日志和权限的功能
    @Override
    public String getUserName(int id) {
        //先调用日志装饰者的方法，实现日志功能
        logUserServiceDecorator.getUserName(id);
        //再调用权限装饰者的方法，实现权限功能，并返回用户对象
        return authUserServiceDecorator.getUserName(id);
    }
}
