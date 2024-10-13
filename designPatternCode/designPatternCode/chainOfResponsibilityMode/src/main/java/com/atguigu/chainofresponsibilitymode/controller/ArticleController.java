package com.atguigu.chainofresponsibilitymode.controller;

import com.atguigu.chainofresponsibilitymode.domain.Article;
import com.atguigu.chainofresponsibilitymode.service.ResponseEntity;
import com.atguigu.chainofresponsibilitymode.service.ReviewArticleService;
import com.atguigu.chainofresponsibilitymode.util.Result;
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
         * 这种责任链模式的缺点是不够灵活。可以使用迭代器模式+责任链模式组成优化
         */
        Result result = reviewArticleService.reviewArticle(article);
        if(result.isApproved()){
            return ResponseEntity.ok("文章审核通过！");
        }else {
            return ResponseEntity.ok("文章审核未通过！"+result.getReturnMessage());
        }
    }
}
