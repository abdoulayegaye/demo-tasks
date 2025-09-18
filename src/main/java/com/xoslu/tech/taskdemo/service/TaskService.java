package com.xoslu.tech.taskdemo.service;

import com.xoslu.tech.taskdemo.dto.TaskRequestDTO;
import com.xoslu.tech.taskdemo.dto.TaskResponseDTO;
import com.xoslu.tech.taskdemo.exception.TaskBadRequestException;
import com.xoslu.tech.taskdemo.exception.TaskConflictException;
import com.xoslu.tech.taskdemo.exception.TaskNotFoundException;
import com.xoslu.tech.taskdemo.mapper.TaskMapper;
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

    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll().stream().map(TaskMapper::toTaskResponseDTO).toList();
    }

    public TaskRequestDTO createTask(TaskRequestDTO taskRequestDTO) {
        if(taskRepository.getByName(taskRequestDTO.getName()).isPresent()) {
            throw new TaskConflictException("La tâche '"+taskRequestDTO.getName()+"' existe déja dans la BD");
        }
        if(taskRequestDTO.getName().isBlank()) {
            throw new TaskBadRequestException("Le nom de la tâche est obligatoire");
        }
        Task task = TaskMapper.toTask(taskRequestDTO);
        task.setCompleted(Boolean.FALSE);
        task = taskRepository.save(task);
        return TaskMapper.toTaskRequestDTO(task);
    }

    public TaskResponseDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id).get();
        return TaskMapper.toTaskResponseDTO(task);
    }

    public TaskResponseDTO updateTask(Long id, Task task) {
        Task taskToUpdate = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("La tâche d'ID '" + id + "' n'existe pas"));
        if (task.getName() != null) {
            taskToUpdate.setName(task.getName());
        }
        if (task.getCompleted() != null) {
            taskToUpdate.setCompleted(task.getCompleted());
        }
        Task updatedTask = taskRepository.save(taskToUpdate);
        return TaskMapper.toTaskResponseDTO(updatedTask);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
