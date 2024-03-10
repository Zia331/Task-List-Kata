package com.codurance.training.tasks.command;

import com.codurance.training.tasks.CommandInterface;

public class ErrorCommand implements CommandInterface {
    public ErrorCommand(){}

    public String execute(String commandLine) {
        return String.format("I don't know what the command \"%s\" is.", commandLine);
    }
}