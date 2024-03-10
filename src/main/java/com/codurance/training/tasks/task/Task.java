package com.codurance.training.tasks.task;

import com.codurance.training.tasks.TaskInterface;

public final class Task implements TaskInterface {
    private final long id;
    private final String description;
    private boolean done;

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String show() {
        return String.format("    [%c] %d: %s%n", (this.done ? 'x' : ' '), this.id, this.description);
    }
}
