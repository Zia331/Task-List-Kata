package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.usecase.commands.ShowCommand;

public class ShowController implements ControllerInterface{
    private final ShowCommand showCommand;
    public ShowController(ShowCommand showCommand){
        this.showCommand = showCommand;
    }

    @Override
    public String parse(String commandLine) {
        return showCommand.execute(commandLine);
    }
}
