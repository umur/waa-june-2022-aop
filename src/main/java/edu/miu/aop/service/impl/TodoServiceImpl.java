package edu.miu.aop.service.impl;

import edu.miu.aop.dtos.TodoDto;
import edu.miu.aop.entity.Todo;
import edu.miu.aop.repository.TodoRepo;
import edu.miu.aop.service.TodoService;
import org.aspectj.weaver.ast.Var;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepo todoRepo;

    @Autowired
    private ModelMapper modelMapper;

    public TodoServiceImpl(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Override
    public List<TodoDto> getAll() {

        return StreamSupport.stream(todoRepo.findAll().spliterator(), false)
                .map(u -> modelMapper.map(u, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto getById(int id) {
        return modelMapper.map(todoRepo.findById(id).get(), TodoDto.class);
    }

    @Override
    public TodoDto save(TodoDto todoDto) {
       var todo = todoRepo.save(modelMapper.map(todoDto, Todo.class));
       return modelMapper.map(todo, TodoDto.class);
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
