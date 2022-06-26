package edu.miu.aop.service.impl;

import edu.miu.aop.entity.Todo;
import edu.miu.aop.repository.TodoRepo;
import edu.miu.aop.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepo todoRepo;

    public TodoServiceImpl(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Override
    public List<Todo> getAll() {
        return (List<Todo>) todoRepo.findAll();
    }

    @Override
    public Todo getById(int id) {
        Optional<Todo> todo = todoRepo.findById(id);
        return todo.orElse(null);
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepo.save(todo);
    }

    @Override
    public boolean delete(int id) {
        boolean deleted = false;
        Optional<Todo> todo = todoRepo.findById(id);

        if (todo.isPresent()) {
            todoRepo.delete(todo.get());
            deleted = true;
        }
        return deleted;
    }
}
