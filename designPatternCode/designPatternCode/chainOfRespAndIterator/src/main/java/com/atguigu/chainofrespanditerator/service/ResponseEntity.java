package com.atguigu.chainofrespanditerator.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity<T> {
    private T body;

    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<>(body);
    }


}
