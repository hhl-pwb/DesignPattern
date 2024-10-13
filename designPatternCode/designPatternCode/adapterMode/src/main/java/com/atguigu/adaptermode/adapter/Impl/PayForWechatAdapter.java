package com.atguigu.adaptermode.adapter.Impl;

import cn.hutool.extra.spring.SpringUtil;
import com.atguigu.adaptermode.adapter.PayAdapter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//微信支付的适配器
@Component("WECHAT")
public class PayForWechatAdapter implements PayAdapter {

    @Override
    public boolean support(String adapter) {
        return SpringUtil.getBean(adapter) instanceof PayForWechatAdapter;
    }

    @Override
    public String pay(String id, BigDecimal amount, Object adapter) {
        //调用了微信的API
        // ..
        // 返回支付结果
        return "使用微信支付" + amount + "元";
    }
}
