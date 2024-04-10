package com.codurance.training.tasks.entity;

import com.codurance.training.tasks.ddd.ValueObject;

public record TaskId(String value) implements ValueObject {
    public static TaskId of(long id) {
        return new TaskId(String.valueOf(id));
    }

    public static TaskId of(String id) {
        return new TaskId(id);
    }

    @Override
    public String toString(){
        return value;
    }
}
