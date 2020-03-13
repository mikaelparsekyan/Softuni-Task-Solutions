package com.example.project.exceptions.user;

public class UserLoginException extends Exception{
    public UserLoginException() {
        super("Incorrect email / password!");
    }
}
