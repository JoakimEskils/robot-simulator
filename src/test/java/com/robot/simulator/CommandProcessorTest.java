package com.robot.simulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.mockito.Mockito.*;

class CommandProcessorTest {
    private Robot robot;
    private CommandExecutor executor;
    private CommandProcessor processor;

    @BeforeEach
    void setup() {
        robot = mock(Robot.class);
        processor = new CommandProcessor(robot);
        executor = new CommandExecutor(robot);
    }

    @Test
    void testProcessCommands_withValidCommands() throws IOException {
        // Create a temporary file with commands
        File tempFile = File.createTempFile("commands", ".txt");
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println("PLACE,1,2,NORTH");
            writer.println("MOVE");
            writer.println("LEFT");
            writer.println("RIGHT");
            writer.println("REPORT");
        }

        processor.processCommands(tempFile.getAbsolutePath());

        // We expect the robot to receive the right calls
        Position position = new Position(1, 2);
        PlaceCommand place = new PlaceCommand(position, Direction.NORTH);
        verify(robot).place(position, Direction.NORTH);
        verify(robot).move();
        verify(robot).left();
        verify(robot).right();
        verify(robot).report();

        // Clean up temp file
        tempFile.delete();
    }

    @Test
    void testProcessCommands_withInvalidCommand() throws IOException {
        File tempFile = File.createTempFile("commands", ".txt");
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println("INVALIDCOMMAND");
        }

        processor.processCommands(tempFile.getAbsolutePath());

        // No interactions with robot on invalid command
        verifyNoInteractions(robot);

        tempFile.delete();
    }
}
