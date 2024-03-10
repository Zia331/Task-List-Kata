package com.codurance.training.tasks.command;

import com.codurance.training.tasks.CommandInterface;
import com.codurance.training.tasks.task.TaskList;

public class AddCommand implements CommandInterface {

    private final TaskList taskList;

    public AddCommand(TaskList taskList){
        this.taskList = taskList;
    }

    public String execute(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];

        boolean status = true;
        if (subcommand.equals("project")) {
            taskList.addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            status = taskList.addTask(projectTask[0], projectTask[1]);
        }else{
            return "failed";
        }

        if(status){
            return "success";
        }
        return "failed";
    }
}
