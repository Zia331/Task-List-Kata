package com.codurance.training.tasks.usecase.commands;

import com.codurance.training.tasks.entity.*;
import com.codurance.training.tasks.usecase.CommandInterface;

public class ShowCommand implements CommandInterface {
    private final TaskList taskList;

    public ShowCommand(TaskList taskList){
        this.taskList = taskList;
    }

    @Override
    public String execute(String commandLine) {
        StringBuilder result = new StringBuilder();
        for (Project project : taskList.getProjects()){
            result.append(project.getName()).append("\n");
            for (Task task : project.getTasks()){
                String taskInfo = String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
                result.append(taskInfo);
            }
            result.append("\n");
        }
        return result.toString();
    }
}
