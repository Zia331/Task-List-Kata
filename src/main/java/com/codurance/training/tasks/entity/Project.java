package com.codurance.training.tasks.entity;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private final List<Task> tasks = new ArrayList<>();
    private final String name;
    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public List<Task> getTasks(){
        return tasks;
    }
    public void add(Task task){
        tasks.add(task);
    }
}
