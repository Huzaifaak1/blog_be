package com.example.blog.blog.exceptions;

public class UserSaveException extends RuntimeException{
    public UserSaveException(String message){
        super(message);
    }
}
