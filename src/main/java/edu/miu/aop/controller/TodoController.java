package edu.miu.aop.controller;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.entity.Todo;
import edu.miu.aop.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("todo")
@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @ExecutionTime
    @GetMapping()
    public List<Todo> getTodoList() {
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") int id) {
        Todo todo = todoService.getById(id);
        return todo != null ? new ResponseEntity<>(todo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExecutionTime
    @PostMapping()
    public ResponseEntity<String> storeTodo(@RequestBody Todo todo) {
        return todoService.save(todo) != null ? new ResponseEntity<>("Saved Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Saved Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> storeTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        Todo exTodo = todoService.getById(id);
        todo.setId(id);
        return exTodo != null ? todoService.save(todo) != null
                ? new ResponseEntity<>("Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") int id) {
        Todo exTodo = todoService.getById(id);
        return exTodo != null ? todoService.delete(id)
                ? new ResponseEntity<>("Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}