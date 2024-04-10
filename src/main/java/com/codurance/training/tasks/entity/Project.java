package com.codurance.training.tasks.entity;

import com.codurance.training.tasks.ddd.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project implements Entity<ProjectName> {
    private final List<Task> tasks = new ArrayList<>();
    private final ProjectName name;
    public Project(ProjectName name) {
        this.name = name;
    }

    public ProjectName getName() {
        return name;
    }
    @Override
    public ProjectName getId() {
        return name;
    }

    public TaskId getTaskId(String idString){
        for(Task t: tasks){
            if(Objects.equals(t.getId().toString(), idString)){
                return t.getId();
            }
        }
        return null;
    }

    public List<TaskId> getTaskIds(){
        List<TaskId> projectNames = new ArrayList<>();
        for(Task t: tasks){
            projectNames.add(t.getId());
        }
        return projectNames;
    }

    public String getTaskDescription(TaskId taskId){
        for(Task t: tasks){
            if(t.getId()==taskId){
                return t.getDescription();
            }
        }
        return "";
    }

    public Boolean getTaskStatus(TaskId taskId){
        for(Task t: tasks){
            if(t.getId()==taskId){
                return t.isDone();
            }
        }
        return false;
    }

    public Boolean setTaskStatus(TaskId taskId, Boolean isDone){
        for(Task t: tasks){
            if(t.getId()==taskId){
                t.setDone(isDone);
                return true;
            }
        }
        return false;
    }

    public void add(Task task){
        tasks.add(task);
    }
}
