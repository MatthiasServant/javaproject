package com.javaproject.exception;

public class ProductNotFoundExpression extends RuntimeException{
    public ProductNotFoundExpression(String message) {
        super(message);
    }
}
