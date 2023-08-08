package com.example.CarbonBackend.exception;

public abstract class BaseException extends Exception{

    public BaseException(String code) {
        super(code);
    }

}