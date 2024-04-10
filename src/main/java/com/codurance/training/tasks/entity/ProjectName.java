package com.codurance.training.tasks.entity;

import com.codurance.training.tasks.ddd.ValueObject;

public record ProjectName(String value) implements ValueObject {
    public static ProjectName of(String name) {
        return new ProjectName(name);
    }

    @Override
    public String toString(){
        return value;
    }
}
