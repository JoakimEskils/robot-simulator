package com.robot.simulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class CommandProcessorTest {
    private Robot robot; // Use the interface
    private CommandProcessor commandProcessor;

    @BeforeEach
    void setUp() {
        robot = mock(Robot.class); // Mock the interface, not the implementation
        commandProcessor = new CommandProcessor(robot);
    }

    @Test
    void testInvalidPlaceCommand() {
        // Invalid inputs, should not call place
        commandProcessor.processCommand("PLACE");
        commandProcessor.processCommand("PLACE,1,2");
        commandProcessor.processCommand("PLACE,a,b,NORTH");
        commandProcessor.processCommand("PLACE,0,0,NORTHEAST");

        verify(robot, never()).place(anyInt(), anyInt(), any());
    }

    @Test
    void testValidPlaceCommand() {
        commandProcessor.processCommand("PLACE,5,5,NORTH");

        verify(robot).place(5, 5, Direction.NORTH);
    }
}
