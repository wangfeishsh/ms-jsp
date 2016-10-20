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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
