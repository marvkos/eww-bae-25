package at.technikum.todoapp.controller;

import at.technikum.todoapp.entity.Todo;
import at.technikum.todoapp.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> readAll() {
        return List.of(
                new Todo("Buy food", LocalDateTime.now(), false),
                new Todo("Clean", LocalDateTime.now(), false)
        );
    }

    @GetMapping("/{id}")
    public Todo read(@PathVariable String id) {
        return new Todo("Buy food", LocalDateTime.now(), false);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody @Valid Todo todo) {
        return this.todoService.create(todo);
    }

    @PutMapping("/{id}")
    public Todo update(
            @PathVariable String id,
            @RequestBody Todo todo
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    public Todo delete(@PathVariable String id) {
        return null;
    }
}
