package com.codurance.training.tasks.usecase.commands;

import com.codurance.training.tasks.entity.TaskList;

public class AddProjectCommand {
    private final TaskList taskList;
    public AddProjectCommand(TaskList taskList){
        this.taskList = taskList;
    }
    public String execute(String projectName) {
        taskList.addProject(projectName);
        return "success";
    }
}
