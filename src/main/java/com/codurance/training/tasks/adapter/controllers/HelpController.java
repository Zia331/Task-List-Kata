package com.codurance.training.tasks.adapter.controllers;

import com.codurance.training.tasks.usecase.commands.HelpCommand;

public class HelpController implements ControllerInterface{
    private final HelpCommand helpCommand = new HelpCommand();
    public HelpController(){}

    @Override
    public String parse(String commandLine) {
        return helpCommand.execute(commandLine);
    }
}
