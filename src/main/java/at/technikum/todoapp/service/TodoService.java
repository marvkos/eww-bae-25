package at.technikum.todoapp.service;

import at.technikum.todoapp.entity.Todo;
import at.technikum.todoapp.exception.EntityAlreadyExistsException;
import at.technikum.todoapp.exception.EntityNotFoundException;
import at.technikum.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo) {
        todoRepository.findByTask(todo.getTask())
                .orElseThrow(EntityAlreadyExistsException::new);

        return todoRepository.save(todo);
    }

    public Todo getById(String id) {
        return todoRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }
}
