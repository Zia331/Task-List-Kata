package com.codurance.training.tasks.usecase.commands;

import com.codurance.training.tasks.entity.*;
import com.codurance.training.tasks.usecase.CommandInterface;

import java.util.List;
import java.util.Map;

public class ShowCommand implements CommandInterface {
    private final TaskList taskList;

    public ShowCommand(TaskList taskList){
        this.taskList = taskList;
    }

    @Override
    public String execute(String commandLine) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, List<Long>> entry : taskList.getProjectAndTasks().entrySet()){
            String projectName = entry.getKey();
            List<Long> taskIds = entry.getValue();

            result.append(projectName).append("\n");

            for (Long taskId: taskIds){
                String taskInfo = String.format(
                        "    [%c] %d: %s%n",
                        (taskList.getTaskStatus(projectName,taskId) ? 'x' : ' '),
                        taskId,
                        taskList.getTaskDescription(projectName,taskId)
                );
                result.append(taskInfo);
            }
            result.append("\n");
        }
        return result.toString();
    }
}
