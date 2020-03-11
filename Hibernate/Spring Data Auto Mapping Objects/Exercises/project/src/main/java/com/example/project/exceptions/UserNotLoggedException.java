package com.example.project.exceptions;

public class UserNotLoggedException extends Exception{
    public UserNotLoggedException() {
        super("User is not logged!");
    }
}
