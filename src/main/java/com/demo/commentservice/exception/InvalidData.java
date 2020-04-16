package com.demo.commentservice.exception;

public class InvalidData extends RuntimeException {
    public InvalidData() {
        super();
    }

    public InvalidData(String msg) {
        super(msg);
    }

    public InvalidData(String msg, Exception exception) {
        super(msg, exception);
    }
}
