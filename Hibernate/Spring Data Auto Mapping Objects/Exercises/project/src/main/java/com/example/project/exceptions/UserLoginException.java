package com.example.project.exceptions;

public class UserLoginException extends Exception{
    public UserLoginException() {
        super("Incorrect email / password!");
    }
}
