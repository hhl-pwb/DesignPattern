package com.atguigu.chainofresponsibilitymode.service;

import com.atguigu.chainofresponsibilitymode.domain.Article;
import com.atguigu.chainofresponsibilitymode.handler.ReviewHandler;
import com.atguigu.chainofresponsibilitymode.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewArticleService {
    @Autowired
    private ReviewHandler reviewHandler;

    public Result reviewArticle(Article article) {
        return reviewHandler.review(article);
    }
}
