package com.atguigu.adaptermode.adapter.Impl;

import cn.hutool.extra.spring.SpringUtil;
import com.atguigu.adaptermode.adapter.PayAdapter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//支付宝支持的适配器
@Component("ALIPAY")
public class PayForAlipayAdapter implements PayAdapter {

    @Override
    public boolean support(String adapter) {
        return SpringUtil.getBean(adapter) instanceof PayForAlipayAdapter;
    }

    @Override
    public String pay(String id, BigDecimal amount, Object adapter) {
        // 调用支付宝的API
        // ...
        // 返回支付结果
        return "使用支付宝支" + amount + "元";
    }
}
