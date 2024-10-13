package com.atguigu.chainofrespanditerator.handler.imple;


import com.atguigu.chainofrespanditerator.domain.Article;
import com.atguigu.chainofrespanditerator.handler.ReviewHandler;
import com.atguigu.chainofrespanditerator.util.Result;
import org.springframework.stereotype.Component;

@Component("IMAGE")
public class ImageReviewHandler implements ReviewHandler {
    @Override
    public Result review(Article article) {
        //进行图片审核
        boolean containInappropriateImage = check(article.getContent());//检查文章中是否包含不适图片
        if (containInappropriateImage) {
            return new Result(false, "文章中的图片违规！");
        } else {
            //通过所有审核
            return new Result<>(true);
        }
    }

    public boolean check(String content) {
        System.out.println("检查图片....");
        return false;
    }
}
