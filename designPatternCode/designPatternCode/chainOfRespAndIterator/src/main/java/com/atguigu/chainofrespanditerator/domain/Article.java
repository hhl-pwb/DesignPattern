package com.atguigu.chainofrespanditerator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private boolean approved;
    private String content;
    //文章审核策略（指定迭代器的数量）
    private String reViewers;
}
