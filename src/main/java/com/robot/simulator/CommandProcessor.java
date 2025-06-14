package com.robot.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommandProcessor {
    private final Robot robot;

    public CommandProcessor(Robot robot) {
        this.robot = robot;
    }

    public void processCommands(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processCommand(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void processCommand(String commandLine) {
        if (commandLine.startsWith("PLACE")) {
            String[] parts = commandLine.split("[ ,]+");

            if (parts.length == 4) {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                Direction direction = Direction.valueOf(parts[3]);
                robot.place(x, y, direction);
            }
        } else if ("MOVE".equals(commandLine)) {
            robot.move();
        } else if ("LEFT".equals(commandLine)) {
            robot.left(); // Updated to match Robot.java
        } else if ("RIGHT".equals(commandLine)) {
            robot.right(); // Updated to match Robot.java
        } else if ("REPORT".equals(commandLine)) {
            System.out.println("Output: " + robot.getX() + "," + robot.getY() + "," + robot.getDirection());
        }
    }
}
