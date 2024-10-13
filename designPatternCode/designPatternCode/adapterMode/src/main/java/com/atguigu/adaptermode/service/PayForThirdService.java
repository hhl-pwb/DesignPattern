package com.atguigu.adaptermode.service;

import com.atguigu.adaptermode.adapter.PayAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

// 支付服务类，使用适配器模式实现多种支付方式
@Service
public class PayForThirdService {

    @Autowired
    private List<PayAdapter> payAdapters;

    public String payForThird(String id, BigDecimal amount, String type) {
        for (PayAdapter payAdapter : payAdapters) {
            if (payAdapter.support(type)) {
                return payAdapter.pay(id, amount, type);
            }
        }
        return "不支持该支付方式";
    }
}
