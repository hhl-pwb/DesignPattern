package com.atguigu.strategicmode.service.strategy;

import com.atguigu.strategicmode.strategy.PayStrategy;
import org.springframework.stereotype.Service;

@Service(value = "PAYPAL")
public class PayPalPayStrategy implements PayStrategy {
    @Override
    public String pay(double amount) {
        return "使用Paypal支付了" + amount + "元";
    }
}
