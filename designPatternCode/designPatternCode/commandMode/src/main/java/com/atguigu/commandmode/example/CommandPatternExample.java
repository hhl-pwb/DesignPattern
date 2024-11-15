package com.atguigu.commandmode.example;

import com.atguigu.commandmode.example.service.CouponService;
import com.atguigu.commandmode.example.service.ProductService;
import com.atguigu.commandmode.example.service.StockService;
import com.atguigu.commandmode.example.task.impl.GetCouponTask;
import com.atguigu.commandmode.example.task.impl.GetProductTask;
import com.atguigu.commandmode.example.task.impl.GetStockTask;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CommandPatternExample {
    public static void main(String[] args) throws Exception {
        //调用者（Invoker）：负责调用命令对象执行请求， 相关的方法包括设置命令对象
        //执行命令对象等，在这个例子中，调用者的线程池对象pool,它提供了submit方法来设置和执行命令对象。
        //创建一个相乘池对象，指定线程数量是4
        ExecutorService pool = Executors.newFixedThreadPool(4);
        //创建一个集合，用于保存future对象
        Collection<Future<Object>> futures = new LinkedList<>();
        //记录开始时间
        long startTime = System.currentTimeMillis();
        //创建提交获取商品信息任务、获取库存数量任务、获取优惠券信息任务、并将返回的Future对象加入集合
        futures.add(pool.submit(new GetProductTask(new ProductService(), 1)));
        futures.add(pool.submit(new GetStockTask(new StockService(), 1)));
        futures.add(pool.submit(new GetCouponTask(new CouponService(), 100)));
        //遍历集合，调用每个Future对象的get方法，获取每个任务的返回值，并打印结果
        for (Future<Object> future : futures) {
            Object result = future.get();
            System.out.println("Result: " + result);
        }
        //记录结束时间
        long endTime = System.currentTimeMillis();
        //计算并打印总的执行时间
        long totalTime = endTime - startTime;
        System.out.println("Total Time: " + totalTime + " ms");
        //关闭线程池
        pool.shutdown();

    }
}
