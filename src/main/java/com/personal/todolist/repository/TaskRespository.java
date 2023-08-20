package com.personal.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.todolist.entities.Task;

public interface TaskRespository extends JpaRepository<Task, Long>{
    
}
