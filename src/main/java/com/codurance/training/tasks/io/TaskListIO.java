package com.codurance.training.tasks.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskListIO implements TaskListIOInterface {
    BufferedReader in;
    PrintWriter out;

    public TaskListIO(BufferedReader in, PrintWriter out){
        this.in = in;
        this.out = out;
    }

    @Override
    public String input() throws IOException {
        return in.readLine();
    }

    @Override
    public void output(String output) {
        out.print(output);
        out.flush();
    }
}
