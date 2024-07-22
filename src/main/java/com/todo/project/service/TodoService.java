package com.todo.project.service;


import com.todo.project.entity.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAll();

    Todo findById(int theId);

    Todo save(Todo theTodo);

    void deleteById(int theId);

}
