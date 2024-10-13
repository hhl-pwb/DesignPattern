package com.atguigu.decoratormode.service.decorator;

import com.atguigu.decoratormode.service.UserService;

// 定义一个抽象的装饰者类，它实现了UserService接口,并且持有一个UserService对象引用
public abstract class UserServiceDecorator implements UserService {
    // 被装饰的UserService对象
    protected UserService userService;

    //通过构造方法注入被装饰的service对象
    public UserServiceDecorator(UserService userService) {
        this.userService = userService;
    }

    // 装饰者类默认实现了UserService接口的方法，但是可以在子类中进行覆盖或者扩展
    @Override
    public String getUserName(int id) {
        return userService.getUserName(id);
    }
}
