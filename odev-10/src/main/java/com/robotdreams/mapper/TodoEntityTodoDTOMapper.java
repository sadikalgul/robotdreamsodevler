package com.robotdreams.mapper;

import com.robotdreams.model.Todo;
import com.robotdreams.model.dto.TodoDTO;
import org.springframework.stereotype.Component;

@Component
public class TodoEntityTodoDTOMapper implements BaseMapper<TodoDTO, Todo>{
    @Override
    public TodoDTO map(Todo todo, Object... params) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todo.getId());
        todoDTO.setUserId(todo.getUserId());
        todoDTO.setTitle(todo.getTitle() );
        todoDTO.setCompleted(todo.isCompleted());
        return todoDTO;
    }
}
