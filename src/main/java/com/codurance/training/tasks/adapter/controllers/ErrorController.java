package com.codurance.training.tasks.adapter.controllers;

public class ErrorController implements ControllerInterface{
    public ErrorController(){}

    @Override
    public String parse(String commandLine) {
        return String.format("I don't know what the command \"%s\" is.", commandLine);
    }
}
