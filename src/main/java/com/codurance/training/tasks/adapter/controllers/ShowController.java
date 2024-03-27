package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.usecase.TaskListCommand;

public class ShowController implements ControllerInterface{
    private final TaskListCommand taskListCommand;
    public ShowController(TaskListCommand taskListCommand){
        this.taskListCommand = taskListCommand;
    }

    @Override
    public String parse(String commandLine) {
        return taskListCommand.execute("show "+commandLine);
    }
}
