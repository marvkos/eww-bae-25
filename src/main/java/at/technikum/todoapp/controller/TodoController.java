package at.technikum.todoapp.controller;

import at.technikum.todoapp.entity.Todo;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @GetMapping
    public List<Todo> readAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Todo read(@PathVariable String id) {
        return new Todo("Buy food", LocalDateTime.now(), false);
    }

    @PostMapping
    public Todo create(@RequestBody @Valid Todo todo) {
        return null;
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
