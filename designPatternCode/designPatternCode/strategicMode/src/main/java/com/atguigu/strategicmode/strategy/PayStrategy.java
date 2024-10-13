package com.atguigu.strategicmode.strategy;

/**
 * 抽象策略类，定义了一个公共的接口，用于封装不同的算法
 */
public interface PayStrategy {
    public String pay(double amount);
}
