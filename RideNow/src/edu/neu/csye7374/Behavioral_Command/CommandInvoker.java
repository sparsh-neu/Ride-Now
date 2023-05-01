package edu.neu.csye7374.Behavioral_Command;

public class CommandInvoker {
    private CommandAPI command;
    private static CommandInvoker instance;
    private CommandInvoker() {
    }

    public static CommandInvoker getInstance() {
        if (instance == null) {
            instance = new CommandInvoker();
        }
        return instance;
    }
    public CommandInvoker(CommandAPI command) {
        this.command = command;
    }

    public CommandInvoker setCommand(CommandAPI command){
        this.command = command;
        return this;
    }

    public String invoke(){
        return command.execute();

    }
}
