package com.atguigu.strategicmode.service;

import com.atguigu.strategicmode.strategy.PayStrategy;
import org.springframework.stereotype.Service;

/**
 * 环境类，持有一个策略对象的引用，并根据不同的情况选择不同的策略执行
 */
@Service
public class PayService {
    // 声明一个私有的策略对象
    private PayStrategy payStrategy;

    // 构造方法，传入一个具体的策略对象，采用构造注入的方式
    public PayService(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    /**
     * 使用set方法，切换不同的策略对象，
     *
     * @param payStrategy
     */
    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    /**
     * 定义一个方法执行策略
     *
     * @param amount
     * @return
     */
    public String pay(double amount) {
        return payStrategy.pay(amount);
    }


}
