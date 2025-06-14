package com.robot.simulator;

public final class RightCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.right();
    }
}