package com.xoslu.tech.taskdemo.exception;

public class TaskConflictException extends RuntimeException {
    public TaskConflictException(String message) {
        super(message);
    }
}
