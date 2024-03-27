package com.codurance.training.tasks.entity;

import java.util.*;

public final class TaskList {
    private final List<Project> projects = new ArrayList<>();
    private long lastId = 0;
    public TaskList() {}

    public boolean setDone(String idString, boolean done) {
        long taskId = Long.parseLong(idString);
        for (Project project : projects){
            for (Long id : project.getTaskIds()) {
                if (taskId == id) {
                    project.setTaskStatus(taskId, done);
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

    public Map<String,List<Long>> getProjectAndTasks(){
        Map<String,List<Long>> info = new LinkedHashMap<>();
        for(Project p: projects){
            info.put(p.getName(),p.getTaskIds());
        }
        return info;
    }

    public String getTaskDescription(String projectName, Long taskId){
        for (Project p: projects){
            if(Objects.equals(p.getName(),projectName)){
                return p.getTaskDescription(taskId);
            }
        }
        return "";
    }

    public Boolean getTaskStatus(String projectName, Long taskId){
        for (Project p: projects){
            if(Objects.equals(p.getName(),projectName)){
                return p.getTaskStatus(taskId);
            }
        }
        return false;
    }

    private long nextId() {
        return ++lastId;
    }
}
