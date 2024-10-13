package com.atguigu.decoratormode.service;

/**
 * 定义一个接口，表示service的抽象组件
 */
public interface UserService {

    /**
     * 获取用户的方法
     */
    String getUserName(int id);
}
