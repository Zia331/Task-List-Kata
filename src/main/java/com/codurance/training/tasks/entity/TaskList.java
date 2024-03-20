package com.codurance.training.tasks.entity;

import java.util.ArrayList;
import java.util.Objects;

public final class TaskList {
    private final ArrayList<Project> projects = new ArrayList<>();
    private long lastId = 0;
    public TaskList() {}

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

    public boolean isProjectAvailable(String name){
        for (Project p: projects){
            if(Objects.equals(p.getName(),name)){
                return true;
            }
        }
        return false;
    }

    public void addProject(String name) {
        projects.add(new Project(name));
    }

    public void addTask(String project, String description) {
        for (Project p: projects){
            if(Objects.equals(p.getName(),project)){
                p.add(new Task(nextId(), description, false));
            }
        }
    }

    public ArrayList<Project> getProjects(){
        return projects;
    }

    private long nextId() {
        return ++lastId;
    }
}
