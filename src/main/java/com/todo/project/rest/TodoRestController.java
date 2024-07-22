package com.todo.project.rest;

import com.todo.project.entity.Project;
import com.todo.project.entity.Todo;
import com.todo.project.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoRestController {

    private TodoService todoService;

    @Autowired
    public TodoRestController(TodoService theTodoService) {
        this.todoService = theTodoService;
    }

    @GetMapping("/todo")
    public List<Todo> findAll(){
        return todoService.findAll();
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable int todoId){
        Todo theTodo=todoService.findById(todoId);
        if (theTodo==null){
            throw new RuntimeException("todo id not found "+todoId);
        }
        return theTodo;
    }

    @PostMapping("/todo")
    public Todo addTodo(@RequestBody Todo theTodo){
        theTodo.setId(0);
        Todo dbTodo=todoService.save(theTodo);
        return dbTodo;
    }

    @PutMapping("/todo")
    public Todo updateTodo(@RequestBody Todo theTodo){
        Todo dbTodo=todoService.save(theTodo);
        return dbTodo;
    }

    @DeleteMapping("/todo/{todoId}")
    public String deleteTodo(@PathVariable int todoId){
        Todo tempTodo=todoService.findById(todoId);
        if (tempTodo==null){
            throw new RuntimeException("todo id not found - "+todoId);
        }
        todoService.deleteById(todoId);
        return "deleted todo id - "+todoId;
    }
}
