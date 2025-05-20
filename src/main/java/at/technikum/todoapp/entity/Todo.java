package at.technikum.todoapp.entity;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public class Todo {

    private String id;

    @NotBlank
    private String task;

    private LocalDateTime due;

    private boolean done;

    public Todo(String task, LocalDateTime due, boolean done) {
        this.id = UUID.randomUUID().toString();
        this.task = task;
        this.due = due;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDateTime getDue() {
        return due;
    }

    public void setDue(LocalDateTime due) {
        this.due = due;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
