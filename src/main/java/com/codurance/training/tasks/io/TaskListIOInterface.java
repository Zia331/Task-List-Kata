package com.codurance.training.tasks.io;

import java.io.IOException;

public interface TaskListIOInterface {
    public String input() throws IOException;
    public void output(String output);
}
