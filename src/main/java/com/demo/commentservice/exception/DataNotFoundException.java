package com.demo.commentservice.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String msg, Exception e) {
        super(msg, e);
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }
}
