package com.robot.simulator.command;

import com.robot.simulator.model.Robot;

public class CommandExecutor {
    private final Robot robot;

    public CommandExecutor(Robot robot) {
        this.robot = robot;
    }

    public void execute(Command command) {
        command.execute(robot);
    }
}
