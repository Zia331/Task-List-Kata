package com.codurance.training.tasks.adapter;

public class ConsolePresenter {

    public ConsolePresenter(){}

    public String presentResult(String res){
        if(!res.equals("success")){
            return res;
        }
        return "";
    }
}
