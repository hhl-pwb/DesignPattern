package com.atguigu.chainofrespanditerator.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private T isApproved;
    private String returnCode;
    private String returnMessage;

    public Result(T data) {
        this.isApproved = data;
    }


    public Result(T isApproved, String returnMessage) {
        this.isApproved = isApproved;
        this.returnMessage = returnMessage;
    }
}
