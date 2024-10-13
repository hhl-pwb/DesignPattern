package com.atguigu.chainofresponsibilitymode.handler;

import com.atguigu.chainofresponsibilitymode.domain.Article;
import com.atguigu.chainofresponsibilitymode.util.Result;

public interface ReviewHandler {
    Result review(Article article);
}
