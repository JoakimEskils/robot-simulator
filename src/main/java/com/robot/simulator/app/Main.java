package com.robot.simulator.app;

import com.robot.simulator.command.CommandProcessor;
import com.robot.simulator.model.RobotImpl;

public class Main {
    public static void main(String[] args) {
        RobotImpl robot = new RobotImpl();
        CommandProcessor processor = new CommandProcessor(robot);

        processor.processCommands("src/main/resources/commands.txt");
    }
}
