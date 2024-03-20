package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.commands.CheckCommand;
import com.codurance.training.tasks.usecase.commands.UncheckCommand;

public class UncheckController implements ControllerInterface{
    private final UncheckCommand uncheckCommand;

    public UncheckController(UncheckCommand uncheckCommand){
        this.uncheckCommand = uncheckCommand;
    }

    @Override
    public String parse(String taskId) {
        return uncheckCommand.execute(taskId);
    }
}
