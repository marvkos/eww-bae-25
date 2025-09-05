package at.technikum.todoapp.controller;

import at.technikum.todoapp.entity.Todo;
import at.technikum.todoapp.security.UserPrincipal;
import at.technikum.todoapp.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public Todo read(@PathVariable String id) {
        return todoService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(
            @RequestBody @Valid Todo todo,
            @AuthenticationPrincipal UserPrincipal userPrincipal
            ) {
        String userId = userPrincipal.getUserId();
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
