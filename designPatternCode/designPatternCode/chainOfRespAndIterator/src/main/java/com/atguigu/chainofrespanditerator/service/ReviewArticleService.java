package com.atguigu.chainofrespanditerator.service;


import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.atguigu.chainofrespanditerator.domain.Article;
import com.atguigu.chainofrespanditerator.handler.ReviewHandler;
import com.atguigu.chainofrespanditerator.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewArticleService {
    @Autowired
    private ReviewHandler reviewHandler;

    private List<ReviewHandler> reviewHandlers;

    public Result reviewArticle(Article article) {
        reviewHandlers = buildHandlers(article);
        Iterator<ReviewHandler> iterator = reviewHandlers.iterator();
        Result result = null;
        while (iterator.hasNext()){
            ReviewHandler review = iterator.next();
            result = review.review(article);
            if(!(Boolean) result.getIsApproved()){
                return result;
            }
        }
        article.setApproved(true);
        //数据入库....
        // ...
        // 返回结果
        return result;
    }

    private List<ReviewHandler> buildHandlers(Article article) {
        return StrUtil.split(article.getReViewers(), ",").stream()
                .map(beanName -> (ReviewHandler) SpringUtil.getBean(beanName))
                .collect(Collectors.toList());
    }
}
