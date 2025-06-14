package com.robot.simulator.command;

import com.robot.simulator.model.Robot;

public interface Command {
    void execute(Robot robot);
}