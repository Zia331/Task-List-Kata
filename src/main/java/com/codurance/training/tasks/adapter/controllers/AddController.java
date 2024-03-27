package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.usecase.TaskListCommand;

public class AddController implements ControllerInterface{
    private final TaskListCommand taskListCommand;
    public AddController(TaskListCommand taskListCommand){
        this.taskListCommand = taskListCommand;
    }

    @Override
    public String parse(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];

        if (subcommand.equals("project")) {
            return taskListCommand.execute("addProject "+subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            return taskListCommand.execute("addTask "+subcommandRest[1]);
        }
        return "failed";
    }
}
