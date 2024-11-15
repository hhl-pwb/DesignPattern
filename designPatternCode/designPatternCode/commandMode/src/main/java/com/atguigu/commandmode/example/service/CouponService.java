package com.atguigu.commandmode.example.service;

/**
 * 接收者（Receiveer）：执行命令的相关操作，是具体命令对象的业务逻辑实现者。
 * 在这个例子中，接收者是商品服务类ProductService.
 * 库存服务类StockService 和 优惠券服务类CouponService.
 * 他们分别提供了获取商品信息，获取库存数量和获取优惠券信息的方法。
 */
public class CouponService {
    //获取优惠券信息方法，并打印结果
    public String getCoupon(int userId) throws Exception {
        String result = "8折优惠券";
        //模拟网络延时或数据库查询等操作，休眠2秒
        Thread.sleep(2000);
        System.out.println("Use ID:" + userId + ",Coupon:" + result);
        return result;
    }
}
