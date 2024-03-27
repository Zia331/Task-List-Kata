package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.usecase.TaskListCommand;
public class UncheckController implements ControllerInterface{
    private final TaskListCommand taskListCommand;
    public UncheckController(TaskListCommand taskListCommand){
        this.taskListCommand = taskListCommand;
    }

    @Override
    public String parse(String taskId) {
        return taskListCommand.execute("uncheck "+taskId);
    }
}
