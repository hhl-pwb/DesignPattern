package com.atguigu.chainofrespanditerator.controller;


import com.atguigu.chainofrespanditerator.domain.Article;
import com.atguigu.chainofrespanditerator.service.ResponseEntity;
import com.atguigu.chainofrespanditerator.service.ReviewArticleService;
import com.atguigu.chainofrespanditerator.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    private ReviewArticleService reviewArticleService;

    @PostMapping("/articles/review")
    public ResponseEntity<String> reviewArticle(@RequestBody Article article) {
        /**
         * 迭代器模式+责任链模式组成优化
         */
        Result result = reviewArticleService.reviewArticle(article);
        if((Boolean) result.getIsApproved()){
            return ResponseEntity.ok("文章审核通过！");
        }else {
            return ResponseEntity.ok("文章审核未通过！"+result.getReturnMessage());
        }
    }
}
