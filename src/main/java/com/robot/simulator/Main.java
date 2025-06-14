package com.robot.simulator;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        CommandProcessor processor = new CommandProcessor(robot);

        processor.processCommands("src/main/resources/commands.txt");
    }
}
