package com.atguigu.delegationmode.pay;

import com.atguigu.delegationmode.pay.impl.AliPay;
import com.atguigu.delegationmode.pay.impl.WeChatPay;

/**
 * 委派模式是一种特殊的静态代理模式，可以理解为全权代理，委派模式的基本作用是负责任务的调用和分配任务
 * 将任务分配和执行分离开来。委派模式是与行为型模式，不是GOF 23种设计模式之一。
 * 有些人任务委派模式是代理模式和策略模式的组合，因为他们都可以在运行时切换不同的对象或者算法，但代理模式注重过程，而策略模式注重结果
 * 委派模式可以看作是一种使用了委托技术的策略模式，因为他们都可以通过聚合来替代继承，实现代码的服用和解耦。
 */
public class TestPay {
    public static void main(String[] args) {
        //创建一个微信支付对象
        WeChatPay weChatPay = new WeChatPay();
        //创建一个支付宝支付对象
        AliPay aliPay = new AliPay();
        //创建一个微信代理对象
        PayProxy weChatPayProxy = new PayProxy(weChatPay);
        //创建一个支付宝代理对象
        PayProxy aliPayProxy = new PayProxy(aliPay);
        //使用微信代理对象进行支付
        weChatPayProxy.pay(100);
        //使用支付宝代理对象进行支付
        aliPayProxy.pay(200);
    }
}
