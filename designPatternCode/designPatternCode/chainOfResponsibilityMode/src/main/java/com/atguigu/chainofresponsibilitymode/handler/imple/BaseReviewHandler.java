package com.atguigu.chainofresponsibilitymode.handler.imple;

import com.atguigu.chainofresponsibilitymode.domain.Article;
import com.atguigu.chainofresponsibilitymode.handler.ReviewHandler;
import com.atguigu.chainofresponsibilitymode.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class BaseReviewHandler implements ReviewHandler {
    @Autowired
    private SensitiveWordRevieHandler sensitiveWordRevieHandler;

    @Override
    public Result review(Article article) {
        // 进行基础审核，检查字数是否达标
        int wordCount = article.getContent().split("\\s").length;
        if (wordCount <= 100) {
            return sensitiveWordRevieHandler.review(article);
        } else {
            return new Result(false, "字数违规！");
        }
    }
}
