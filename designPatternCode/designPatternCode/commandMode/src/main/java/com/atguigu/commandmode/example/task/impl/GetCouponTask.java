package com.atguigu.commandmode.example.task.impl;

import com.atguigu.commandmode.example.service.CouponService;
import com.atguigu.commandmode.example.task.Task;

/**
 * 具体命令类：获取优惠券信息任务
 */
public class GetCouponTask implements Task {

    // 持有接收者对象
    private CouponService couponService;
    //用户Id
    private int userId;

    //构造方法
    public GetCouponTask(CouponService couponService, int userId) {
        this.couponService = couponService;
        this.userId = userId;
    }

    //实现执行方法
    @Override
    public Object call() throws Exception {
        //调用接收者的获取优惠券信息方法，并返回结果
        return couponService.getCoupon(userId);
    }
}
