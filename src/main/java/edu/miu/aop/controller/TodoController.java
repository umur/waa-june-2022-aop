package edu.miu.aop.controller;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.dtos.TodoDto;
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
    public List<TodoDto> getTodoList() {
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") int id) {
        TodoDto TodoDto = todoService.getById(id);
        return TodoDto != null ? new ResponseEntity<>(TodoDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExecutionTime
    @PostMapping()
    public ResponseEntity<String> storeTodo(@RequestBody TodoDto TodoDto) {
        return todoService.save(TodoDto) != null ? new ResponseEntity<>("Saved Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Saved Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> storeTodo(@PathVariable("id") int id, @RequestBody TodoDto TodoDto) {
        TodoDto exTodo = todoService.getById(id);
        TodoDto.setId(id);
        return exTodo != null ? todoService.save(TodoDto) != null
                ? new ResponseEntity<>("Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Updated Successfully", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") int id) {
        TodoDto exTodo = todoService.getById(id);
        return exTodo != null ? todoService.delete(id)
                ? new ResponseEntity<>("Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>("Not Deleted Successfully", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}