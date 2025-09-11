package com.xoslu.tech.taskdemo.repository;

import com.xoslu.tech.taskdemo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
