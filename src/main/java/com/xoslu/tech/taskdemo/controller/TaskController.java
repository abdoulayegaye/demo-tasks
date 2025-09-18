package com.xoslu.tech.taskdemo.controller;

import com.xoslu.tech.taskdemo.dto.TaskRequestDTO;
import com.xoslu.tech.taskdemo.dto.TaskResponseDTO;
import com.xoslu.tech.taskdemo.model.Task;
import com.xoslu.tech.taskdemo.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name = "Tâches", description = "Gestion des tâches")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @Operation(summary = "Ajouter une nouvelle tâche", description = "Crée et ajoute une tâche dans la BD")
    public TaskRequestDTO create(@RequestBody TaskRequestDTO taskRequestDTO) {
        return taskService.createTask(taskRequestDTO);
    }

    @GetMapping
    @Operation(summary = "Lister les tâches", description = "Liste toutes les tâches dans la BD")
    public List<TaskResponseDTO> list() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une tâche", description = "Récupére une tâche de la BD via son ID")
    public TaskResponseDTO get(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une tâche", description = "Modifie une tâche dans la BD via son ID")
    public TaskResponseDTO update(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une tâche", description = "Supprime une tâche dans la BD via son ID")
    public void delete(@PathVariable("id") Long id) {
        taskService.deleteTaskById(id);
    }
}
