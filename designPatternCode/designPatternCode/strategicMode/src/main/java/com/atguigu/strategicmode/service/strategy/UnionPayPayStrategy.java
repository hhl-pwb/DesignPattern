package com.atguigu.strategicmode.service.strategy;

import com.atguigu.strategicmode.strategy.PayStrategy;
import org.springframework.stereotype.Service;

@Service(value = "UNIONPAY")
public class UnionPayPayStrategy implements PayStrategy {

    @Override
    public String pay(double amount) {
        return "使用银联付了" + amount + "元";
    }
}
