package com.atguigu.delegationmode.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.atguigu.delegationmode.pay.PayProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 委派模式是一种特殊的静态代理模式，可以理解为全权代理，委派模式的基本作用是负责任务的调用和分配任务
 * 将任务分配和执行分离开来。委派模式是与行为型模式，不是GOF 23种设计模式之一。
 * 有些人任务委派模式是代理模式和策略模式的组合，因为他们都可以在运行时切换不同的对象或者算法，但代理模式注重过程，而策略模式注重结果
 * 委派模式可以看作是一种使用了委托技术的策略模式，因为他们都可以通过聚合来替代继承，实现代码的服用和解耦。
 */
@RestController
public class PayController {
    @GetMapping("/pay")
    public void pay(@RequestParam String type){
        PayProxy payProxy = new PayProxy(SpringUtil.getBean(type));
        payProxy.pay(100);

    }
}
