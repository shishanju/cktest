package com.lemon.common;

import lombok.Data;

@Data
public class Result {

    private String status;

    private Object data;

    private String message;

    public Result(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Result(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    public Result(String status,String message) {
        this.status = status;
        this.message = message;
    }
}
