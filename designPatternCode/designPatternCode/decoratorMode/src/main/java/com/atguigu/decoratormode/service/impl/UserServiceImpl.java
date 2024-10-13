package com.atguigu.decoratormode.service.impl;

import com.atguigu.decoratormode.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary //spring初始化时，默认的UserService类
//定义一个具体的组件，表示一个普通的service
@Service("userService")//@Service注解表示这是一个service层的bean
public class UserServiceImpl implements UserService {

    //使用Autowired注解注入一个UserDao类型的bean对象
    //@Autowired
    //private UserDao userDao;


    @Override
    public String getUserName(int id) {
        //调用userDao的方法来获取用户
        // return userDao.findUserById(id);
        return "admin";
    }
}
