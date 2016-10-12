package com.bao.model;

import lombok.Data;

/**
 * Created by user on 16/9/18.
 */
@Data
public class ResponseResult<T> {
    private String errorCode;
    private String errorMessage;
    private T data;
}
