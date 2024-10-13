package com.atguigu.chainofrespanditerator.handler;


import com.atguigu.chainofrespanditerator.domain.Article;
import com.atguigu.chainofrespanditerator.util.Result;

public interface ReviewHandler {
    Result review(Article article);
}
