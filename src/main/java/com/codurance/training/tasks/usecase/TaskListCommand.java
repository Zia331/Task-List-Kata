package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.usecase.commands.*;
import com.codurance.training.tasks.entity.TaskList;

import java.util.Map;
import java.util.HashMap;
import java.util.function.BiFunction;

public class TaskListCommand implements CommandInterface {
    private final TaskList taskList = new TaskList();
    private final static Map<String, BiFunction<String, String, String>> commands = new HashMap<>();


    public TaskListCommand() {
        commands.put("show", (command, rest) -> {
            ShowCommand showCommand = new ShowCommand(taskList);
            return showCommand.execute(rest);
        });
        commands.put("addProject", (command, rest) -> {
            AddProjectCommand addProjectCommand = new AddProjectCommand(taskList);
            return addProjectCommand.execute(rest);
        });
        commands.put("addTask", (command, rest) -> {
            AddTaskCommand addTaskCommand = new AddTaskCommand(taskList);
            return addTaskCommand.execute(rest);
        });
        commands.put("check", (command, rest) -> {
            CheckCommand checkCommand = new CheckCommand(taskList);
            return checkCommand.execute(rest);
        });
        commands.put("uncheck", (command, rest) -> {
            UncheckCommand uncheckCommand = new UncheckCommand(taskList);
            return uncheckCommand.execute(rest);
        });
        commands.put("help", (command, rest) -> {
            HelpCommand helpCommand = new HelpCommand();
            return helpCommand.execute(rest);
        });
    }

    @Override
    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        String rest = commandRest.length > 1 ? commandRest[1] : "";

        BiFunction<String, String, String> commander = commands.getOrDefault(command, (cmd, arg) -> "failed");
        return commander.apply(command, rest);
    }
}
