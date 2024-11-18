package com.atguigu.statusmode.domain;

import com.atguigu.statusmode.pay.OrderStatus;
import com.atguigu.statusmode.pay.impl.PaidStatus;

/**
 * 定义一个订单类，用于维护当前的订单状态对象
 */
public class Order {
    //声明一个私有的订单状态对象
    private OrderStatus status;

    //构造方法，此处初始化订单状态为已支付状态
    public Order() {
        this.status = new PaidStatus();
    }

    // 获取当前的订单状态对象
    public OrderStatus getStatus() {
        return status;
    }

    // 设置当前的订单状态对象
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // 定义一个代理方法，调用订单状态的支付行为
    public void pay() {
        status.pay(this);
    }

    //定义一个代理方法，调用订单状态的发货行为
    public void ship() {
        status.ship(this);
    }

    //定义一个代理方法，调用订单状态的收货行为
    public void recevie() {
        status.recevie(this);
    }
}
