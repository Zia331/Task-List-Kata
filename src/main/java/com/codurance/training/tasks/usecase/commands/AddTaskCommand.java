package com.codurance.training.tasks.usecase.commands;

import com.codurance.training.tasks.entity.TaskList;
import com.codurance.training.tasks.usecase.CommandInterface;

public class AddTaskCommand implements CommandInterface {
    private final TaskList taskList;
    public AddTaskCommand(TaskList taskList){
        this.taskList = taskList;
    }

    public String execute(String taskInfo) {
        String[] splitTaskInfo = taskInfo.split(" ", 2);
        if(taskList.isProjectAvailable(splitTaskInfo[0])){
            taskList.addTask(splitTaskInfo[0], splitTaskInfo[1]);
            return "success";
        }
        return "project unavailable";
    }
}
