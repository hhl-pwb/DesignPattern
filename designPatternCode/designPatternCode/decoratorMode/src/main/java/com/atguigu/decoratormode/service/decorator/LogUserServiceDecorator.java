package com.atguigu.decoratormode.service.decorator;

import com.atguigu.decoratormode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//定义一个具体的装饰者类，他表示日志功能
@Service("logUserService")//@Service注解表示这是一个service层的bean
public class LogUserServiceDecorator extends UserServiceDecorator {
    //通过构造方法注入被装饰的service对象， 并使用@Autowired注解让SpringBoot自动为我们选择合适的bean对象
    @Autowired
    public LogUserServiceDecorator(UserService userService) {
        super(userService);
    }

    //在原有UserService的基础上添加日志记录功能
    @Override
    public String getUserName(int id) {
        // 记录请求开始的时间
        long startTime = System.currentTimeMillis();
        /**
         * LogUserServiceDecorator中可以使用super.getUser替换userService.getUser,
         * 因为super.getUser就是调用父类的getUser方法。
         * 而父类的getUser方法就是调用userService的getUser方法。
         * 所以，这两种写法是等价的，都是调用被装饰的对象的getUser方法。
         * 但是，为了保持一致性和可读性，建议使用userService.getUser这中写法。
         * 因为这样更能体现出装饰者模式的思想，即通过一个被装饰的对象的引用来实现装饰的功能。
         */
        //调用被装饰对象的方法
        String userName = userService.getUserName(id);
        // 记录请求结束的时间
        long endTime = System.currentTimeMillis();
        // 计算请求的耗时
        System.out.println("请求耗时：" + (endTime - startTime) + "毫秒");
        return userName;
    }
}
