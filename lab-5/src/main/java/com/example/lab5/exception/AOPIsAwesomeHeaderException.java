package com.example.lab5.exception;

public class AOPIsAwesomeHeaderException extends Exception {
    public AOPIsAwesomeHeaderException(String header_required) {
        super(header_required);
    }
}
