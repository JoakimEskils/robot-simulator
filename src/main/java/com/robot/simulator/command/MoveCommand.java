package com.robot.simulator.command;

import com.robot.simulator.model.Robot;

public final class MoveCommand implements Command {
    @Override
    public void execute(Robot robot) {
        robot.move();
    }
}
