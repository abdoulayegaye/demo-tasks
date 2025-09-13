package com.xoslu.tech.taskdemo.repository;

import com.xoslu.tech.taskdemo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM tasks WHERE name = :name")
    //@Query(value = "SELECT t FROM Task t WHERE t.name = :name")
    Optional<Task> getByName(String name);
}
