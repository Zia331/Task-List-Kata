package com.codurance.training.tasks.usecase.commands;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.CommandInterface;

public class CheckCommand implements CommandInterface {
    private final TaskList taskList;
    public CheckCommand(TaskList taskList){
        this.taskList = taskList;
    }

    @Override
    public String execute(String taskId) {
        if(taskList.setDone(taskId, true)){
            return "success";
        }
        return "failed";
    }
}
