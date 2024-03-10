package com.codurance.training.tasks.task;

import com.codurance.training.tasks.TaskInterface;

import java.util.ArrayList;
public class Project implements TaskInterface {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private final String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void add(Task task){
        tasks.add(task);
    }

    public boolean isDone() {
        // return true if whole project isDone
        return true;
    }

    public void setDone(boolean done) {
        // set whole project to done
    }

    public String show() {
        return String.format("%s\n", name);
    }
}
