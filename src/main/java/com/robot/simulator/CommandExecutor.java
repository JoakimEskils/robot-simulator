package com.robot.simulator;

public class CommandExecutor {
    private final Robot robot;

    public CommandExecutor(Robot robot) {
        this.robot = robot;
    }

    public void execute(Command command) {
        command.execute(robot);
    }
}
