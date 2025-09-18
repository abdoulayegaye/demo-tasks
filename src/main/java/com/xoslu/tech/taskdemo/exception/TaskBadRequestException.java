package com.xoslu.tech.taskdemo.exception;

public class TaskBadRequestException extends RuntimeException {
    public TaskBadRequestException(String message) {
        super(message);
    }
}
