package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.usecase.commands.AddProjectCommand;
import com.codurance.training.tasks.usecase.commands.AddTaskCommand;

public class AddController implements ControllerInterface{
    private final AddProjectCommand addProjectCommand;
    private final AddTaskCommand addTaskCommand;
    public AddController(AddProjectCommand addProjectCommand, AddTaskCommand addTaskCommand){
        this.addProjectCommand = addProjectCommand;
        this.addTaskCommand =addTaskCommand;
    }

    @Override
    public String parse(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];

        if (subcommand.equals("project")) {
            return addProjectCommand.execute(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            return addTaskCommand.execute(subcommandRest[1]);
        }
        return "failed";
    }
}
