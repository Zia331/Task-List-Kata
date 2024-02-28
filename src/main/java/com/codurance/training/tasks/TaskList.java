package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements TaskInterface {
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private long lastId = 0;
    public TaskList() {}

    public String show() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            result.append(project.getKey()).append("\n");
            for (Task task : project.getValue()) {
                result.append(task.show());
            }
            result.append("\n");
        }
        return result.toString();
    }

    Boolean check(String idString) {
        return setDone(idString, true);
    }

    Boolean uncheck(String idString) {
        return setDone(idString, false);
    }

    public Boolean add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            return addTask(projectTask[0], projectTask[1]);
        }else{
            return false;
        }
        return true;
    }

    private Boolean setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return true;
                }
            }
        }
        return false;
    }

    private void addProject(String name) {
        tasks.put(name, new ArrayList<Task>());
    }

    private Boolean addTask(String project, String description) {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            return false;
        }
        projectTasks.add(new Task(nextId(), description, false));
        return true;
    }

    private long nextId() {
        return ++lastId;
    }
}
