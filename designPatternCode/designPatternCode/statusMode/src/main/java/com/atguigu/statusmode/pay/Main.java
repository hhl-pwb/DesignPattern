package com.atguigu.statusmode.pay;

import com.atguigu.statusmode.domain.Order;

public class Main {
    public static void main(String[] args) {
        //创建一个订单对象
        Order order = new Order();
        // 打印当前订单状态
        System.out.println(order.getStatus());
        //调用订单状态的行为方法
        //order.getStatus().pay(order); //不能再次支付
        //order.getStatus().ship(order);//可以发货，并切换到已发货状态
        //order.getStatus().recevie(order);//可以收货，并切换到已收货状态
        //上面的写法能用，但是有些冗长，不够优雅，所以通过order类中的代理方法进行了优化
        order.recevie();
        order.pay();
        order.ship();
    }
}
