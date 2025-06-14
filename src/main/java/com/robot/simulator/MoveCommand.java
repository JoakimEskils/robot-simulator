package com.robot.simulator;

public final class MoveCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.move();
    }
}
