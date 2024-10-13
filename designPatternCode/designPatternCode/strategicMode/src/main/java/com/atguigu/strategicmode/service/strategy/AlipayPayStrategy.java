package com.atguigu.strategicmode.service.strategy;

import com.atguigu.strategicmode.strategy.PayStrategy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary //默认值，在spring容器初始化时候，必须指定，否则spring容器在初始化时候不知道注入的哪个类，默认使用AliPay这种方式
@Service(value = "ALIPAY")
public class AlipayPayStrategy implements PayStrategy {
    @Override
    public String pay(double amount) {
        return "使用支付宝付了" + amount + "元";
    }
}
