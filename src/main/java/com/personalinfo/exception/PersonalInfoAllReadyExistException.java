package com.personalinfo.exception;

public class PersonalInfoAllReadyExistException extends RuntimeException {
    private String message;

    public PersonalInfoAllReadyExistException(String msg){
        super(msg);
        this.message=msg;
    }
}
