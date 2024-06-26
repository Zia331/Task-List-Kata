package com.codurance.training.tasks.entity;

import com.codurance.training.tasks.ddd.Entity;

public final class Task implements Entity<TaskId> {
    private final TaskId id;
    private final String description;
    private boolean done;

    public Task(TaskId id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    @Override
    public TaskId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}