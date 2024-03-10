package com.codurance.training.tasks.command;

import com.codurance.training.tasks.CommandInterface;
import com.codurance.training.tasks.task.TaskList;

public class CheckCommand implements CommandInterface {

    private final TaskList taskList;

    public CheckCommand(TaskList taskList){
        this.taskList = taskList;
    }

    public String execute(String taskId) {
        if(taskList.setDone(taskId, true)){
            return "success";
        }else{
            return "failed";
        }
    }
}
