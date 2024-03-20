package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.commands.CheckCommand;

public class CheckController implements ControllerInterface{
    private final CheckCommand checkCommand;
    public CheckController(CheckCommand checkCommand){
        this.checkCommand = checkCommand;
    }

    @Override
    public String parse(String taskId) {
        return checkCommand.execute(taskId);
    }
}
