package com.robot.simulator.command;

import com.robot.simulator.model.Robot;

public final class LeftCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.left();
    }
}