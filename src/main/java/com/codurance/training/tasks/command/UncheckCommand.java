package com.codurance.training.tasks.command;

import com.codurance.training.tasks.CommandInterface;
import com.codurance.training.tasks.task.TaskList;

public class UncheckCommand implements CommandInterface {

    private final TaskList taskList;

    public UncheckCommand(TaskList taskList){
        this.taskList = taskList;
    }

    public String execute(String taskId) {
        if(taskList.setDone(taskId, false)){
            return "success";
        }else{
            return "failed";
        }
    }
}
