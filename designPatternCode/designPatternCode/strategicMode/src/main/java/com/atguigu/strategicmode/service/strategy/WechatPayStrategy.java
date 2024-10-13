package com.atguigu.strategicmode.service.strategy;

import com.atguigu.strategicmode.strategy.PayStrategy;
import org.springframework.stereotype.Service;

@Service(value = "WECHAT")
public class WechatPayStrategy implements PayStrategy {
    @Override
    public String pay(double amount) {
        return "使用微信付了" + amount + "元";
    }
}
