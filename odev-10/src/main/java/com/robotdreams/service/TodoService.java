package com.robotdreams.service;

import com.robotdreams.model.Todo;
import com.robotdreams.model.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    List<TodoDTO> findTodosByCompleteStatus(boolean status);
    TodoDTO saveTodo(TodoDTO todoDTO);
}
