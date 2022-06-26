package edu.miu.aop.service;

import edu.miu.aop.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    List<Todo> getAll();

    Todo getById(int id);

    Todo save(Todo todo);

    boolean delete(int id);
}
