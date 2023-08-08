package com.example.CarbonBackend.exception;

import com.example.CarbonBackend.entity.User;

public class UserException extends BaseException{
    public UserException(String code) {
        super("user." + code);
    }

    public static UserException emailNotFound(){
        return new UserException("not.found");
    }

    public static UserException emailAlreadyExist(){
        return new UserException("email.already.exist");
    }

    public static UserException notEnoughPoint(){
        return new UserException("email.already.exist");
    }
}
