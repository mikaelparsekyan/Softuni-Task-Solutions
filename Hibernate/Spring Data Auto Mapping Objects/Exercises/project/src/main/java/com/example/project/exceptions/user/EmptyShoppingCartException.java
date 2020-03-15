package com.example.project.exceptions.user;

public class EmptyShoppingCartException extends Exception{
    public EmptyShoppingCartException() {
        super("Cannot buy! Your shopping cart is empty!");
    }
}
