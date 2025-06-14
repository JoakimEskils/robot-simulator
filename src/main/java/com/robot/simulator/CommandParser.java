package com.robot.simulator;

public class CommandParser {

    public Command parse(String commandLine) {
        if (commandLine == null || commandLine.isEmpty()) {
            return new InvalidCommand(commandLine);
        }

        // Split the entire command line by commas
        String[] parts = commandLine.split(",");

        // The command word is always the first part, uppercased for consistency
        String commandWord = parts[0].toUpperCase();

        switch (commandWord) {
            case "PLACE":
                // PLACE command must have exactly 4 parts: PLACE,x,y,DIRECTION
                if (parts.length != 4) {
                    return new InvalidCommand(commandLine);
                }
                return parsePlaceCommand(parts, commandLine);

            case "MOVE":
                // MOVE command should be just "MOVE" (no commas)
                return commandLine.equalsIgnoreCase("MOVE") ? new MoveCommand() : new InvalidCommand(commandLine);

            case "LEFT":
                return commandLine.equalsIgnoreCase("LEFT") ? new LeftCommand() : new InvalidCommand(commandLine);

            case "RIGHT":
                return commandLine.equalsIgnoreCase("RIGHT") ? new RightCommand() : new InvalidCommand(commandLine);

            case "REPORT":
                return commandLine.equalsIgnoreCase("REPORT") ? new ReportCommand() : new InvalidCommand(commandLine);

            default:
                return new InvalidCommand(commandLine);
        }
    }

    private Command parsePlaceCommand(String[] parts, String originalCommandLine) {
        try {
            int x = Integer.parseInt(parts[1].trim());
            int y = Integer.parseInt(parts[2].trim());
            Direction direction = Direction.valueOf(parts[3].trim().toUpperCase());

            Position position = new Position(x, y);
            return new PlaceCommand(position, direction);
        } catch (Exception e) {
            return new InvalidCommand(originalCommandLine);
        }
    }
}
