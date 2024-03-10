package com.codurance.training.tasks;

import com.codurance.training.tasks.task.TaskList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;

public class TaskListApp implements Runnable{
    private static final String QUIT = "quit";
    private final BufferedReader in;
    private final PrintWriter out;
    private final TaskListExecutor executor;

    public TaskListApp(BufferedReader reader, PrintWriter writer, TaskListExecutor executor) {
        this.in = reader;
        this.out = writer;
        this.executor = executor;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        TaskListExecutor taskListExecutor = new TaskListExecutor(new TaskList());
        new TaskListApp(in, out, taskListExecutor).run();
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

            String res = executor.execute(command);
            if(Objects.equals(res, "success")){

            }else{
                out.print(res);
            }
        }
    }
}
