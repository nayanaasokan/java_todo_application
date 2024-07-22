package com.todo.project.service;

import com.todo.project.dao.TodoRepository;
import com.todo.project.entity.Project;
import com.todo.project.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(int theId) {
        Optional<Todo> result=todoRepository.findById(theId);
        Todo theTodo=null;
        if (result.isPresent()){
            theTodo=result.get();
        }
        else{
            throw new RuntimeException("did not find todo id "+theId);
        }
        return theTodo;
    }

    @Override
    public Todo save(Todo theTodo) {
        return todoRepository.save(theTodo);
    }

    @Override
    public void deleteById(int theId) {
        todoRepository.deleteById(theId);
    }

}
