package com.codurance.training.tasks.entity;

import java.util.*;

public final class TaskList {
    private final List<Project> projects = new ArrayList<>();
    private long lastId = 0;
    public TaskList() {}

    public boolean setDone(String idString, boolean done) {
        for (Project project : projects){
            for (TaskId id : project.getTaskIds()) {
                if (Objects.equals(idString, id.toString())) {
                    TaskId taskId = project.getTaskId(idString);
                    if(project.setTaskStatus(taskId, done)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isProjectAvailable(String name){
        for (Project p: projects){
            if(Objects.equals(p.getName().toString(),name)){
                return true;
            }
        }
        return false;
    }

    public void addProject(String name) {
        projects.add(new Project(new ProjectName(name)));
    }

    public void addTask(String project, String description) {
        for (Project p: projects){
            if(Objects.equals(p.getName().toString(),project)){
                p.add(new Task(new TaskId(Long.toString(nextId())), description, false));
            }
        }
    }

    public Map<String,List<TaskId>> getProjectAndTasks(){
        Map<String,List<TaskId>> info = new LinkedHashMap<>();
        for(Project p: projects){
            info.put(p.getName().toString(),p.getTaskIds());
        }
        return info;
    }

    public String getTaskDescription(String projectName, TaskId taskId){
        for (Project p: projects){
            if(Objects.equals(p.getName().toString(),projectName)){
                return p.getTaskDescription(taskId);
            }
        }
        return "";
    }

    public Boolean getTaskStatus(String projectName, TaskId taskId){
        for (Project p: projects){
            if(Objects.equals(p.getName().toString(),projectName)){
                return p.getTaskStatus(taskId);
            }
        }
        return false;
    }

    private long nextId() {
        return ++lastId;
    }
}
