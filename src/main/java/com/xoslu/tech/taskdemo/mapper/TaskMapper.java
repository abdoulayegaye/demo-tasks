package com.xoslu.tech.taskdemo.mapper;

import com.xoslu.tech.taskdemo.dto.TaskRequestDTO;
import com.xoslu.tech.taskdemo.dto.TaskResponseDTO;
import com.xoslu.tech.taskdemo.model.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper {

    public static Task toTask(TaskRequestDTO taskRequestDTO) {
        if(taskRequestDTO == null) {
            return null;
        }
        Task task = new Task();
        task.setName(taskRequestDTO.getName());
        task.setDescription(taskRequestDTO.getDescription());
        return task;
    }

    public static TaskRequestDTO toTaskRequestDTO(Task task) {
        if(task == null) {
            return null;
        }
        return new TaskRequestDTO(task.getName(), task.getDescription());
    }

    public static TaskResponseDTO toTaskResponseDTO(Task task) {
        if(task == null) {
            return null;
        }
        return new TaskResponseDTO(task.getId(), task.getName(), task.getDescription(), task.getCompleted());
    }
}
