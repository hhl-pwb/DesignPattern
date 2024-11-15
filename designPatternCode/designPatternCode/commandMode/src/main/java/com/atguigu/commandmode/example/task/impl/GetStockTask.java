package com.atguigu.commandmode.example.task.impl;

import com.atguigu.commandmode.example.service.StockService;
import com.atguigu.commandmode.example.task.Task;

public class GetStockTask implements Task {
    private StockService stockService;
    private int productId;

    public GetStockTask(StockService stockService, int productId) {
        this.stockService = stockService;
        this.productId = productId;
    }

    @Override
    public Object call() throws Exception {
        return stockService.getStock(productId);
    }
}
