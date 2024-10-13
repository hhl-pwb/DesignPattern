package com.atguigu.adaptermode.adapter;

import java.math.BigDecimal;

//适配器模式的接口
public interface PayAdapter {

    // 判断是否支持该支付方式
    boolean support(String adapter);

    // 支付
    String pay(String id, BigDecimal amount, Object adapter);
}
