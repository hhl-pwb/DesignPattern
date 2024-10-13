package com.atguigu.chainofresponsibilitymode.handler.imple;

import com.atguigu.chainofresponsibilitymode.domain.Article;
import com.atguigu.chainofresponsibilitymode.handler.ReviewHandler;
import com.atguigu.chainofresponsibilitymode.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SensitiveWordRevieHandler implements ReviewHandler {
    @Autowired
    private ImageReviewHandler imageReviewHandler;

    @Override
    public Result review(Article article) {
        // 进行敏感词审核
        // 检查文章是否包含敏感词的逻辑
        boolean containSensitiveWord = check(article.getContent());
        if (containSensitiveWord) {
            return new Result(false, "文章中含有敏感词！");
        } else {
            return imageReviewHandler.review(article);
        }
    }

    public boolean check(String content) {
        System.out.println("检查敏感词...");
        return false;
    }
}
