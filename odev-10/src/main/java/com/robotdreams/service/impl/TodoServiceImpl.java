package com.robotdreams.service.impl;

import com.robotdreams.mapper.TodoDTOTodoEntityMapper;
import com.robotdreams.mapper.TodoEntityTodoDTOMapper;
import com.robotdreams.model.Todo;
import com.robotdreams.model.dto.TodoDTO;
import com.robotdreams.repository.TodoRepository;
import com.robotdreams.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoEntityTodoDTOMapper todoEntityTodoDTOMapper;

    private final TodoDTOTodoEntityMapper todoDTOTodoEntityMapper;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository, TodoEntityTodoDTOMapper todoEntityTodoDTOMapper, TodoDTOTodoEntityMapper todoDTOTodoEntityMapper) {
        this.todoRepository = todoRepository;
        this.todoEntityTodoDTOMapper = todoEntityTodoDTOMapper;
        this.todoDTOTodoEntityMapper = todoDTOTodoEntityMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoDTO> findTodosByCompleteStatus(boolean status) {
        List<Todo> todoList = todoRepository.findTodosByCompleted(status);
        List<TodoDTO> todoDTOList = new ArrayList<>();
        todoList.forEach(t -> todoDTOList.add(todoEntityTodoDTOMapper.map(t,null)));
        return todoDTOList;
    }

    @Override
    @Transactional
    public TodoDTO saveTodo(TodoDTO todoDTO) {
        Todo todo = todoDTOTodoEntityMapper.map(todoDTO);
        todoRepository.save(todo);
        return todoDTO;
    }
}
