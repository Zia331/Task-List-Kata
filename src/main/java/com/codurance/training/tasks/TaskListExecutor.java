package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaskListExecutor implements Runnable{
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;
    private final TaskList taskList;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListExecutor(in, out, new TaskList()).run();
    }

    public TaskListExecutor(BufferedReader reader, PrintWriter writer, TaskList taskList) {
        this.in = reader;
        this.out = writer;
        this.taskList = taskList;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                out.print(taskList.show());
                break;
            case "add":
                if(!taskList.add(commandRest[1])){
                    out.printf("Could not find a project with the name \"%s\".", commandRest[1]);
                    out.println();
                }
                break;
            case "check":
                if(!taskList.check(commandRest[1])){
                    out.printf("Could not find a task with an ID of %s.", commandRest[1]);
                    out.println();
                }
                break;
            case "uncheck":
                if(!taskList.uncheck(commandRest[1])){
                    out.printf("Could not find a task with an ID of %s.", commandRest[1]);
                    out.println();
                }
                break;
            case "help":
                help();
                break;
            default:
                error(command);
                break;
        }
    }

    private void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }

    private void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}
