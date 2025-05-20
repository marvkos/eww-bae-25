package at.technikum.todoapp.service;

import at.technikum.todoapp.entity.Todo;
import at.technikum.todoapp.exception.TodoAlreadyExistsException;
import at.technikum.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo) {

        Optional<Todo> todoCheck
                = todoRepository.findByTask(todo.getTask());

        if (todoCheck.isPresent()) {
            throw new TodoAlreadyExistsException();
        }

        return todoRepository.save(todo);
    }
}
