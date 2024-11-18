package com.atguigu.statusmode.pay.impl;

import com.atguigu.statusmode.domain.Order;
import com.atguigu.statusmode.pay.OrderStatus;

/**
 * 定义一个具体的订单状态类，表示已发货状态
 */
public class ShipperStatus implements OrderStatus {
    @Override
    public void pay(Order order) {
        System.out.println("订单已发货，不能再次支付。");
    }

    @Override
    public void ship(Order order) {
        System.out.println("订单已发货，不能再次发货。");
    }

    @Override
    public void recevie(Order order) {
        System.out.println("订单已收货。");
        order.setStatus(new ReceivedStatus());
    }
}
