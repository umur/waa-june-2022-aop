package com.example.lab3.exception;

public class AOPIsAwesomeHeaderException extends Exception {
    public AOPIsAwesomeHeaderException(String header_required) {
        super(header_required);
    }
}
