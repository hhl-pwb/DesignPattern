package com.atguigu.adaptermode.controller;

import com.atguigu.adaptermode.service.PayForThirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private PayForThirdService payForThirdService;

    @PostMapping("/payForThird")
    public String payForThird(@RequestParam String id,
                              @RequestParam BigDecimal amount,
                              @RequestParam String type) {
        return payForThirdService.payForThird(id, amount, type);
    }
}
