package com.atguigu.commandmode.example.task.impl;

import com.atguigu.commandmode.example.service.ProductService;
import com.atguigu.commandmode.example.task.Task;

public class GetProductTask implements Task {

    private ProductService productService;
    private int productId;


    public GetProductTask(ProductService productService, int productId) {
        this.productService = productService;
        this.productId = productId;
    }

    @Override
    public Object call() throws Exception {
        return productService.getProduct(productId);
    }
}
