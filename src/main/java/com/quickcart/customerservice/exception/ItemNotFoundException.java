package com.quickcart.customerservice.exception;

public class ItemNotFoundException  extends RuntimeException{
    public ItemNotFoundException(String message) {
        super(message);
    }
}