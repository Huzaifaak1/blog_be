package com.example.blog.blog.exceptions;

public class AlreadyExists extends RuntimeException{
    public AlreadyExists(String message){
        super(message);
    }
}
