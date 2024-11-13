package com.atguigu.delegationmode.pay;

/**
 * 定义了一个支付代理类，持有一个支付接口的引用
 */
public class PayProxy {
    private Pay pay;
    //通过构造方法传入具体的支付方式
    public PayProxy(Pay pay) {
        this.pay = pay;
    }
    //调用具体的支付方式进行支付
    public void pay(double amount) {
        //1.判断权限
        //2.执行逻辑
        pay.pay(amount);
        //3.记录日志
    }

}
