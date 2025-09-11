package com.xoslu.tech.taskdemo.controller;

import com.xoslu.tech.taskdemo.model.Task;
import com.xoslu.tech.taskdemo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> list() {
        return taskService.getAllTasks();
    }
}
