package com.robot.simulator;

public final class ReportCommand implements Command {
    @Override
    public void execute(Robot robot) {
        System.out.println(robot.report());
    }
}