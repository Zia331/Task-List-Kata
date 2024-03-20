package com.codurance.training.tasks.adapter;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.adapter.controllers.*;
import com.codurance.training.tasks.usecase.commands.AddProjectCommand;
import com.codurance.training.tasks.usecase.commands.AddTaskCommand;
import com.codurance.training.tasks.usecase.commands.CheckCommand;
import com.codurance.training.tasks.usecase.commands.UncheckCommand;
import com.codurance.training.tasks.usecase.commands.ShowCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CommandController {
    private final static Map<String, Function<String, String>> controllers = new HashMap<>();
    private final static TaskList taskList = new TaskList();
    public CommandController() {
        controllers.put("show", command -> {
            ShowController showController = new ShowController(new ShowCommand(taskList));
            return showController.parse(command);
        });
        controllers.put("add", command -> {
            AddController addController = new AddController( new AddProjectCommand(taskList), new AddTaskCommand(taskList));
            return addController.parse(command);
        });
        controllers.put("check", command -> {
            CheckController checkController = new CheckController(new CheckCommand(taskList));
            return checkController.parse(command);
        });
        controllers.put("uncheck", command -> {
            UncheckController uncheckController = new UncheckController(new UncheckCommand(taskList));
            return uncheckController.parse(command);
        });
        controllers.put("help", command -> {
            HelpController helpController = new HelpController();
            return helpController.parse(command);
        });
    }

    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        Function<String, String> controller = controllers.getOrDefault(command, cmd -> {
            ErrorController errorController = new ErrorController();
            return errorController.parse(cmd);
        });

        return controller.apply(commandRest.length > 1 ? commandRest[1] : "");
    }
}
