package com.xoslu.tech.taskdemo.controller;

import com.xoslu.tech.taskdemo.model.Task;
import com.xoslu.tech.taskdemo.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
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
    @Operation(summary = "Ajouter une nouvelle tâche")
    public Task create(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    @Operation(summary = "Lister toutes les tâches")
    public List<Task> list() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une tâche")
    public Task get(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une tâche")
    public Task update(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une tâche")
    public void delete(@PathVariable("id") Long id) {
        taskService.deleteTaskById(id);
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Accessible sans authentification 🚀";
    }

    @GetMapping("/private")
    public String privateEndpoint(@AuthenticationPrincipal Jwt jwt) {
        return "Hello " + jwt.getClaim("preferred_username") + " 🔒";
    }
}
