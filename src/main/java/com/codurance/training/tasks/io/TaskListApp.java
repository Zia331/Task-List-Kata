package com.codurance.training.tasks.io;

import com.codurance.training.tasks.adapter.CommandController;
import com.codurance.training.tasks.adapter.ConsolePresenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaskListApp implements Runnable {
    private static final String QUIT = "quit";
    private final TaskListIO io;
    private final CommandController commandController;
    private final ConsolePresenter commandPresenter;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        TaskListIO io = new TaskListIO(in,out);
        CommandController commandController = new CommandController();
        ConsolePresenter commandPresenter = new ConsolePresenter();
        new TaskListApp(io, commandController, commandPresenter).run();
    }

    public TaskListApp(TaskListIO io, CommandController commandController, ConsolePresenter commandPresenter) {
        this.io = io;
        this.commandController = commandController;
        this.commandPresenter = commandPresenter;
    }

    public void run() {
        while (true) {
            io.output("> ");
            String command;
            try {
                command = io.input();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            io.output(commandPresenter.presentResult(commandController.execute(command)));
        }
    }
}
