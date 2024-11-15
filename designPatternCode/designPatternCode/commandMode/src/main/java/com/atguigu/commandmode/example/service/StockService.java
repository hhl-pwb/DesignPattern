package com.atguigu.commandmode.example.service;

/**
 * 接收者：库存服务类
 */
public class StockService {
    //获取商品库存量方法，并打印结果
    public int getStock(int productId) throws Exception {
        int result = 100;
        //模拟网络延时或数据库查询等操作，休眠2秒
        Thread.sleep(2000);
        System.out.println("Product ID:" + productId + ", Product Name:" + result);
        return result;
    }
}
