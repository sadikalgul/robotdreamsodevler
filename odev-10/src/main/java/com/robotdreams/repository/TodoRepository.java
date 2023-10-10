package com.robotdreams.repository;

import com.robotdreams.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findTodosByCompleted(boolean boll);
}
