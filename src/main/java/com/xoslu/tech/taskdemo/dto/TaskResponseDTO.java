package com.xoslu.tech.taskdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Boolean completed;
}
