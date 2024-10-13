package com.atguigu.chainofresponsibilitymode.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private T data;
    private boolean isApproved;
    private String returnCode;
    private String returnMessage;

    public Result(T data) {
        this.data = data;
    }


    public Result(boolean isApproved, String returnMessage) {
        this.isApproved = isApproved;
        this.returnMessage = returnMessage;
    }
}
