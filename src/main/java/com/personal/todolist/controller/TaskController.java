package com.personal.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.todolist.entities.Task;
import com.personal.todolist.repository.TaskRespository;

@RestController
public class TaskController {

    private final TaskRespository taskRespository;

    public TaskController(TaskRespository taskRespository) {
        this.taskRespository = taskRespository;
    }

    @GetMapping(value = "/task/{taskId}")
    public Task getTaskByID(@PathVariable Long taskId){
        Task task = taskRespository.findById(taskId).get();
        return task;
    }

    @GetMapping(value = "/tasks")
    public List<Task> getTasks(){
        return taskRespository.findAll();
    }

    @PostMapping(value = "/task")
    public Task createTask(@RequestBody Task newTask){
        return taskRespository.save(newTask);
    }
}
