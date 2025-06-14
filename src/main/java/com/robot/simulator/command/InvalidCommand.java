package com.robot.simulator.command;

import com.robot.simulator.model.Robot;

public final class InvalidCommand implements Command {
    private final String commandLine;

    public InvalidCommand(String commandLine) {
        this.commandLine = commandLine;
    }

    @Override
    public void execute(Robot robot) {
        System.out.println("Invalid command ignored: " + commandLine);
    }
}
