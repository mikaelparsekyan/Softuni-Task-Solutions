package com.example.project.exceptions.user;

public class UserNotLoggedException extends Exception{
    public UserNotLoggedException() {
        super("User is not logged!");
    }
}
