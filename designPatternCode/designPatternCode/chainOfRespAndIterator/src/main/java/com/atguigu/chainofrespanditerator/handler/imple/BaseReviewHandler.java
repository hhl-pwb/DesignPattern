package com.atguigu.chainofrespanditerator.handler.imple;


import com.atguigu.chainofrespanditerator.domain.Article;
import com.atguigu.chainofrespanditerator.handler.ReviewHandler;
import com.atguigu.chainofrespanditerator.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

@Primary
@Component("BASE")
public class BaseReviewHandler implements ReviewHandler {
    @Autowired
    private SensitiveWordRevieHandler sensitiveWordRevieHandler;

    @Override
    public Result review(Article article) {
        // 进行基础审核，检查字数是否达标
//        int wordCount = article.getContent().split("\\s").length;
        boolean wordSizeOver = check(article.getContent());
        if (wordSizeOver) {
            return new Result<>(true);
        } else {
            return new Result<>(false, "字数违规！");
        }

    }

    public boolean check(String content){
        System.out.println("检查字数...");
        int wordCount = content.split("\\s").length;
        return wordCount <= 100;
    }
}
