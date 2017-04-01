package com.filipe.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filipe.task.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
