package com.atguigu.statusmode.pay.impl;

import com.atguigu.statusmode.domain.Order;
import com.atguigu.statusmode.pay.OrderStatus;

/**
 * 定义一个具体的订单状态类，表示已支付状态
 */
public class PaidStatus implements OrderStatus {


    @Override
    public void pay(Order order) {
        //已支付状态不能再次支付
        System.out.println("订单已经支付，不能再次支付。");
    }

    @Override
    public void ship(Order order) {
        //已支付状态下可以发货
        System.out.println("订单已经发货。");
        //改变订单状态为已发货状态
        order.setStatus(new ShipperStatus());
    }

    @Override
    public void recevie(Order order) {
        //已发货的状态下不能再次发货
        System.out.println("订单还没有发货，不能再次发货。");
    }
}
