package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.usecase.TaskListCommand;

public class HelpController implements ControllerInterface{

    private final TaskListCommand taskListCommand;
    public HelpController(TaskListCommand taskListCommand){
        this.taskListCommand = taskListCommand;
    }

    @Override
    public String parse(String commandLine) {
        return taskListCommand.execute("help "+commandLine);
    }
}
