package com.atguigu.delegationmode.pay.impl;

import com.atguigu.delegationmode.pay.Pay;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 第一个支付宝支付类，实现支付接口
 */
@Primary  //默认支付方式
@Component("ALI") //组件名称
@Scope("prototype")//设置多例
public class AliPay implements Pay {
    @Override
    public void pay(double amount) {
        System.out.println("使用了支付宝付了" + amount + "元");
    }
}
