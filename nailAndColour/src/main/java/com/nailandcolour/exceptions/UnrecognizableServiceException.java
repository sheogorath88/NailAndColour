package com.nailandcolour.exceptions;

public class UnrecognizableServiceException extends IllegalStateException{
    public UnrecognizableServiceException(String message){
        super(message);
    }
}
