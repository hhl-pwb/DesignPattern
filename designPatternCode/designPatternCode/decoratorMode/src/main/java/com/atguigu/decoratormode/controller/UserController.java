package com.atguigu.decoratormode.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.atguigu.decoratormode.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot中使用装饰者模式给任何一个service添加日志功能，并利用依赖注入来动态地选择被装饰的对象
 * UserController,它处理用户相关请求。
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 处理获取用户的请求
     * 默认：userService，增加日志：logUserService，增加权限authUserService,增加日志和权限logAndAuthUser
     */
    @GetMapping
    public String getUser(@RequestParam("id") int id,
                          @RequestParam("decorator") String decorator) {
        // 调用userService的方法来获取用户，并实现日志功能
        UserService userService = SpringUtil.getBean(decorator);
        return userService.getUserName(id);
    }
}
