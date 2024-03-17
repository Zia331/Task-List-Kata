package com.codurance.training.tasks.entity;

import java.util.ArrayList;
import java.util.Objects;

public final class TaskList {
    private final ArrayList<Project> projects = new ArrayList<>();
    private long lastId = 0;
    public TaskList() {}

    public String show(){
        StringBuilder result = new StringBuilder();
        for (Project project : projects){
            result.append(project.getName()).append("\n");
            for (Task task : project.getTasks()){
                result.append(task.show());
            }
            result.append("\n");
        }
        return result.toString();
    }

    public boolean setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Project project : projects){
            for (Task task : project.getTasks()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return true;
                }
            }
        }
        return false;
    }

    public void addProject(String name) {
        projects.add(new Project(name));
    }

    public boolean addTask(String project, String description) {
        for (Project p: projects){
            if(Objects.equals(p.getName(),project)){
                p.add(new Task(nextId(), description, false));
                return true;
            }
        }
        return false;
    }

    private long nextId() {
        return ++lastId;
    }
}
