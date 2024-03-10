package com.codurance.training.tasks;

import com.codurance.training.tasks.command.*;
import com.codurance.training.tasks.task.TaskList;

import java.util.Objects;

public class TaskListExecutor implements CommandInterface{
    private final TaskList taskList;
    private final ErrorCommand error = new ErrorCommand();
    private final AddCommand add;
    private final CheckCommand check;
    private final UncheckCommand uncheck;

    public TaskListExecutor(TaskList taskList) {
        this.taskList = taskList;
        this.add = new AddCommand(taskList);
        this.check = new CheckCommand(taskList);
        this.uncheck = new UncheckCommand(taskList);
    }

    public String execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return taskList.show();
            case "add":
                String res_add = add.execute(commandRest[1]);
                if(Objects.equals(res_add, "failed")){
                    return String.format("Could not find a project with the name \"%s\".\n", commandRest[1]);
                }else return res_add;
            case "check":
                String res_check = check.execute(commandRest[1]);
                if(Objects.equals(res_check, "failed")){
                    return String.format("Could not find a task with an ID of %s.", commandRest[1]);
                }else return res_check;
            case "uncheck":
                String res_uncheck = uncheck.execute(commandRest[1]);
                if(Objects.equals(res_uncheck, "failed")){
                    return String.format("Could not find a task with an ID of %s.", commandRest[1]);
                }else return res_uncheck;
            case "help":
                return help();
            default:
                return error.execute(command);
        }
    }

    private String help() {
        return "Commands:"
            .concat("  show")
            .concat("  add project <project name>")
            .concat("  add task <project name> <task description>")
            .concat("  check <task ID>")
            .concat("  uncheck <task ID>");
    }
}
