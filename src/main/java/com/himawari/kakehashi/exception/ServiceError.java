package com.himawari.kakehashi.exception;

public class ServiceError extends RuntimeException {
    public ServiceError(Exception e){
        super("問題が発生しました",e);
    }

    public ServiceError(String message,Exception e){
        super(message,e);
    }
}