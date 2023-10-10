package com.robotdreams.restinitiliazer;

import com.robotdreams.model.Todo;
import com.robotdreams.model.dto.TodoDTO;
import com.robotdreams.repository.TodoRepository;
import com.robotdreams.service.TodoService;
import com.robotdreams.service.impl.TodoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class LoadRestTodos implements ApplicationRunner {

    private final TodoService todoService;
    private final RestTemplate restTemplate;
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        TodoDTO[] todoDTOS = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos",TodoDTO[].class);
        List<TodoDTO> todoDTOList = Arrays.asList(todoDTOS);
        todoDTOList.forEach(todoService::saveTodo);

    }
}
