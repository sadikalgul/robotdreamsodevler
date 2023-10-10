package com.robotdreams.mapper;

import com.robotdreams.model.Todo;
import com.robotdreams.model.dto.TodoDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoDTOTodoEntityMapper implements BaseMapper<Todo, TodoDTO> {
    @Override
    public Todo map(TodoDTO todoDTO, Object... params) {
        Todo todo = new Todo();
        if (todoDTO.getId() != 0) todo.setId(todoDTO.getId());
        todo.setCompleted(todoDTO.isCompleted());
        todo.setTitle(todoDTO.getTitle());
        todo.setUserId(todoDTO.getUserId());
        return todo;
    }
}
