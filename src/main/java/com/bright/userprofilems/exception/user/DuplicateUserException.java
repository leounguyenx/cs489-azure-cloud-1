package com.bright.userprofilems.exception.user;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message) {
        super(message);//to return the messsage when we call, e.getMessage()
    }
}
