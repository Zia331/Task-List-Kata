package com.codurance.training.tasks.adapter;

import com.codurance.training.tasks.adapter.controllers.*;
import com.codurance.training.tasks.usecase.TaskListCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CommandController {
    private final static Map<String, Function<String, String>> controllers = new HashMap<>();
    private final TaskListCommand taskListCommand = new TaskListCommand();

    public CommandController() {
        controllers.put("show", command -> {
            ShowController showController = new ShowController(taskListCommand);
            return showController.parse(command);
        });
        controllers.put("add", command -> {
            AddController addController = new AddController(taskListCommand);
            return addController.parse(command);
        });
        controllers.put("check", command -> {
            CheckController checkController = new CheckController(taskListCommand);
            return checkController.parse(command);
        });
        controllers.put("uncheck", command -> {
            UncheckController uncheckController = new UncheckController(taskListCommand);
            return uncheckController.parse(command);
        });
        controllers.put("help", command -> {
            HelpController helpController = new HelpController(taskListCommand);
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
