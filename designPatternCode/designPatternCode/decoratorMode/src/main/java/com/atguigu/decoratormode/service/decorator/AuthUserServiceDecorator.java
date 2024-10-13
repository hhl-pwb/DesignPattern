package com.atguigu.decoratormode.service.decorator;

import com.atguigu.decoratormode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//权限装饰者类，它表示权限检查的功能
@Service("authUserService")//@Service注解表示这是一个service层的bean
public class AuthUserServiceDecorator extends UserServiceDecorator {

    // 通过构造方法注入被装饰的service对象，并使用@Autorwired注解让SpringBoot自动为我们选择合适的bean对象
    @Autowired
    public AuthUserServiceDecorator(UserService userService) {
        super(userService);
    }

    // 在原有的service的基础上添加权限检查的功能
    @Override
    public String getUserName(int id) {
        System.out.printf("进行了权限验证，验证通过后才可以访问service");
        //模拟获取当前用户的角色
        String role = "admin";
        // 检测当前用户是否有权限访问
        if (role.equals("admin")) {
            // 如果有权限，调用被装饰对象的方法
            return userService.getUserName(id);
        } else {
            // 如果没有权限，抛出异常或者返回空对象
            throw new RuntimeException("没有权限访问");
        }
    }
}
