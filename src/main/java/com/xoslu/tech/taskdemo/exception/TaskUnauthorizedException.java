package com.xoslu.tech.taskdemo.exception;

public class TaskUnauthorizedException extends RuntimeException {
    public TaskUnauthorizedException(String message) {
        super(message);
    }
}
