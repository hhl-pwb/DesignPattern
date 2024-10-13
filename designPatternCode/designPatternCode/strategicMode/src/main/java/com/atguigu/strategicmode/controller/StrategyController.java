package com.atguigu.strategicmode.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.atguigu.strategicmode.service.PayService;
import com.atguigu.strategicmode.strategy.PayStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/strategy")
public class StrategyController {
    /**
     * 策略模式是一种行为型设计模式，它定义了一些列的算法，并将他们封装起来，使他们可以相互替换，而不影像客户端使用。
     * 策略模式的主要角色有三个：环境类（Context），抽象策略类（Strategy）和具体策略类（ConcreteStrategy）。
     * 环境类持有一个策略对象的引用，并根据不同情况选择不同的策略执行。
     * 抽象策略类定义一个公共接口，用于封装不同的算法。具体策略类实现了抽象策略类的接口，并提供具体的算法实现。
     */

    /**
     * 模仿四种支付方式
     * 支付方式（WECHAT-微信 ALIPAY-支付宝 UNIONPAY-银联 PAYPAL-Paypal）
     */
    @GetMapping(value = "/pay")
    public String pay(@RequestParam("amount") double amount,
                      @RequestParam("type") String type) {
        /**
         * 此处存在线程不安全问题：
         * spring容器中的组件默认是单例bean,这就导致payService成为多线程共有对象，会被别的线程修改。
         * 以下几种做法可以避免多线程修改变量：
         * 1、controller的pay方法加锁Synchonized，优点：改动小，缺点：性能低。
         * 2、在获取payService对象的时候，是在pay()方法中，通过getBean的形式获取的paaService,直接吧payService由
         * 单例编程多例即可，修改:PayService类顶部加注解@Scode("prototype").
         * 3、直接在pay方法中，StrategyService strategyService = new StrategyService(),这种方法也可以，
         * 但是考虑到PayService类可能比较辅助，可能还有被的bean会被注入，所以new这种情况只适合PayService只有很少
         * 成员变量的情况。
         * 4、如果只是通过@Autorwird/@Resource注解的形式获取payService,此时针对方法2，只在PayService类中修改
         * @Scode("prototype")为多例是不行的，不会生效，还需要在controller类顶部加上@Scode("prototype")。
         * 以上的做法，只是为了避免多线程共有资源，不共有就不会出现变量被被的线程修改的问题，每个线程都有自己的资源。
         *
         */
        // 从应用上下文中获取PayService。
        PayService payService = SpringUtil.getBean(PayService.class);
        // 从应用上下文中根据支付方式获取对应的策略对象
        PayStrategy payStrategy = (PayStrategy) SpringUtil.getBean(type);
        // 切换到对应的策略对象
        payService.setPayStrategy(payStrategy);
        // 调用支付服务的方法，执行策略对象的算法
        return payService.pay(amount);
    }
}