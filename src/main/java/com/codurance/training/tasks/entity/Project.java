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

    public List<Long> getTaskIds(){
        List<Long> projectNames = new ArrayList<>();
        for(Task t: tasks){
            projectNames.add(t.getId());
        }
        return projectNames;
    }

    public String getTaskDescription(Long taskId){
        for(Task t: tasks){
            if(t.getId()==taskId){
                return t.getDescription();
            }
        }
        return "";
    }

    public Boolean getTaskStatus(Long taskId){
        for(Task t: tasks){
            if(t.getId()==taskId){
                return t.isDone();
            }
        }
        return false;
    }

    public Boolean setTaskStatus(Long taskId, Boolean isDone){
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
