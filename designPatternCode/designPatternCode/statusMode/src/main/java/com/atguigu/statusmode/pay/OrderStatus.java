package com.atguigu.statusmode.pay;

import com.atguigu.statusmode.domain.Order;

public interface OrderStatus {


    void pay(Order order);

    void ship(Order order);

    void recevie(Order order);
}
