package com.robot.simulator.command;

import com.robot.simulator.model.Robot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommandProcessor {
    private final CommandParser parser;
    private final CommandExecutor executor;

    public CommandProcessor(Robot robot) {
        this.parser = new CommandParser();
        this.executor = new CommandExecutor(robot);
    }

    public void processCommands(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Command command = parser.parse(line.trim());
                executor.execute(command);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
