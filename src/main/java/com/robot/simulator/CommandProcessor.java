package com.robot.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommandProcessor {
    private final Robot robot; // Use the interface now

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

    void processCommand(String commandLine) {
        if (commandLine.isEmpty()) return; // ignore empty lines

        String command = commandLine.contains(",") ? commandLine.substring(0, commandLine.indexOf(',')) : commandLine;

        switch (command) {
            case "PLACE":
                handlePlaceCommand(commandLine);
                break;
            case "MOVE":
                if (commandLine.equals("MOVE")) robot.move();
                else invalidCommand(commandLine);
                break;
            case "LEFT":
                if (commandLine.equals("LEFT")) robot.left();
                else invalidCommand(commandLine);
                break;
            case "RIGHT":
                if (commandLine.equals("RIGHT")) robot.right();
                else invalidCommand(commandLine);
                break;
            case "REPORT":
                if (commandLine.equals("REPORT")) System.out.println(robot.report());
                else invalidCommand(commandLine);
                break;
            default:
                invalidCommand(commandLine);
                break;
        }
    }

    private void handlePlaceCommand(String commandLine) {
        if (!commandLine.startsWith("PLACE,")) {
            invalidCommand(commandLine);
            return;
        }

        String[] params = commandLine.substring(6).split(","); // skip "PLACE,"
        if (params.length != 3) {
            invalidCommand(commandLine);
            return;
        }

        try {
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            Direction direction = Direction.valueOf(params[2]);

            robot.place(x, y, direction);
        } catch (IllegalArgumentException e) {
            invalidCommand(commandLine);
        }
    }

    private void invalidCommand(String commandLine) {
        System.out.println("Invalid command ignored: " + commandLine);
    }
}
