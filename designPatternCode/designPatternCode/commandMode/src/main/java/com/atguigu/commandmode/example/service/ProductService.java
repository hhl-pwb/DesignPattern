package com.atguigu.commandmode.example.service;

/**
 * 接收者：商品服务
 */
public class ProductService {
    //获取商品信息方法，并打印结果
    public String getProduct(int productId) throws Exception {
        String result = "智能手机";
        //模拟网络延时或数据库查询等操作，休眠2秒
        Thread.sleep(2000);
        System.out.println("Product ID:" + productId + ", Product Name:" + result);
        return result;
    }
}
