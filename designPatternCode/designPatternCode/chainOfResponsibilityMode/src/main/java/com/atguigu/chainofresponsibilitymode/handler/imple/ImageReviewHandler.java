package com.atguigu.chainofresponsibilitymode.handler.imple;

import com.atguigu.chainofresponsibilitymode.domain.Article;
import com.atguigu.chainofresponsibilitymode.handler.ReviewHandler;
import com.atguigu.chainofresponsibilitymode.util.Result;
import org.springframework.stereotype.Component;

@Component
public class ImageReviewHandler implements ReviewHandler {
    @Override
    public Result review(Article article) {
        //进行图片审核
        boolean containInappropriateImage = check(article.getContent());//检查文章中是否包含不适图片
        if (containInappropriateImage) {
            return new Result(false, "文章中的图片违规！");
        } else {
            //通过所有审核
            article.setApproved(true);
            return new Result(true, "通过所有检查");
        }
    }

    public boolean check(String content) {
        System.out.println("已抽取文章中的图片链接....");
        System.out.println("检查图片....");
        return false;
    }
}
