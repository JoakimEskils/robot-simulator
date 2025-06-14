package com.robot.simulator.command;

import com.robot.simulator.model.Robot;

public final class ReportCommand implements Command {
    @Override
    public void execute(Robot robot) {
        System.out.println(robot.report());
    }
}