package com.xoslu.tech.taskdemo.service;

import com.xoslu.tech.taskdemo.model.Task;
import com.xoslu.tech.taskdemo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        task.setCompleted(Boolean.FALSE);
        return taskRepository.save(task);
    }
}
