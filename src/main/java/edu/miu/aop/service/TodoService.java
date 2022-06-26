package edu.miu.aop.service;

import edu.miu.aop.dtos.TodoDto;
import edu.miu.aop.entity.Todo;

import java.util.List;

public interface TodoService {
    List<TodoDto> getAll();

    TodoDto getById(int id);

    TodoDto save(TodoDto todo);

    boolean delete(int id);
}
