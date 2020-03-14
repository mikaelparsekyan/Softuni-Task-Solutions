package com.example.project.exceptions.user;

public class UnsupportedLoginOperation extends Exception {
    public UnsupportedLoginOperation() {
        super("Cannot login! First logout of the current profile!");
    }
}
