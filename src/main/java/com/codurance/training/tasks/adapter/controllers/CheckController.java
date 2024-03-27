package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.usecase.TaskListCommand;

public class CheckController implements ControllerInterface{
    private final TaskListCommand taskListCommand;
    public CheckController(TaskListCommand taskListCommand){
        this.taskListCommand = taskListCommand;
    }

    @Override
    public String parse(String taskId) {
        return taskListCommand.execute("check "+taskId);
    }
}
