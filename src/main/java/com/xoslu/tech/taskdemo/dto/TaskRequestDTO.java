package com.xoslu.tech.taskdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskRequestDTO {
    private String name;
    private String description;
}
