package com.atguigu.delegationmode.pay.impl;

import com.atguigu.delegationmode.pay.Pay;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 定义了一个微信支付类，实现支付接口
 */
@Component("WECHAT")
@Scope("prototype")
public class WeChatPay implements Pay {
    @Override
    public void pay(double amount) {
        System.out.println("使用微信支付" + amount + "元");
    }
}
