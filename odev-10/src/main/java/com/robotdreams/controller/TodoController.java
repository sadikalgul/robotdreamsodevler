package com.robotdreams.controller;

import com.robotdreams.model.dto.TodoDTO;
import com.robotdreams.repository.TodoRepository;
import com.robotdreams.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo-completed/{completed}")
    public List<TodoDTO> getTodosByCompleteStatus(@PathVariable boolean completed){
        return todoService.findTodosByCompleteStatus(completed);

    }

    @PostMapping(value = "/todo")
    public TodoDTO saveTodo(@RequestBody @Valid TodoDTO todoDTO){
        return todoService.saveTodo(todoDTO);
    }

}
