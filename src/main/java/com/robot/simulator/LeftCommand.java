package com.robot.simulator;

public final class LeftCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.left();
    }
}