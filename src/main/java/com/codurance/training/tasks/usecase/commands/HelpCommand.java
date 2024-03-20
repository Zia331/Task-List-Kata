package com.codurance.training.tasks.usecase.commands;

import com.codurance.training.tasks.usecase.CommandInterface;

public class HelpCommand implements CommandInterface {
    public HelpCommand(){}

    @Override
    public String execute(String commandLine) {
        return "Commands:"
            .concat("  show")
            .concat("  add project <project name>")
            .concat("  add task <project name> <task description>")
            .concat("  check <task ID>")
            .concat("  uncheck <task ID>");
    }
}
