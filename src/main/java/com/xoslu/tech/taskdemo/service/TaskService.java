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
        if(taskRepository.getByName(task.getName()).isPresent()) {
            throw new IllegalArgumentException("Task already exists");
        }
        task.setCompleted(Boolean.FALSE);
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public Task updateTask(Long id, Task task) {
        Task taskToUpdate = getTaskById(id);
        taskToUpdate.setName(task.getName());
        taskToUpdate.setCompleted(task.getCompleted());
        return taskRepository.save(taskToUpdate);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
