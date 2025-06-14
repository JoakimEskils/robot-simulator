package com.robot.simulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CommandExecutorTest {
    private Robot robot;
    private CommandExecutor executor;

    @BeforeEach
    void setup() {
        robot = mock(Robot.class);
        executor = new CommandExecutor(robot);
    }

    @Test
    void testExecutePlaceCommand() {
        Position position = new Position(1, 2);
        PlaceCommand place = new PlaceCommand(position, Direction.WEST);
        executor.execute(place);
        verify(robot).place(position, Direction.WEST);
    }

    @Test
    void testExecuteMoveCommand() {
        MoveCommand move = new MoveCommand();
        executor.execute(move);
        verify(robot).move();
    }

    @Test
    void testExecuteLeftCommand() {
        LeftCommand left = new LeftCommand();
        executor.execute(left);
        verify(robot).left();
    }

    @Test
    void testExecuteRightCommand() {
        RightCommand right = new RightCommand();
        executor.execute(right);
        verify(robot).right();
    }

    @Test
    void testExecuteReportCommand() {
        ReportCommand report = new ReportCommand();
        when(robot.report()).thenReturn("Output");
        executor.execute(report);
        verify(robot).report();
    }

    @Test
    void testExecuteInvalidCommandDoesNothing() {
        InvalidCommand invalid = new InvalidCommand("invalid command");
        executor.execute(invalid);
        verifyNoInteractions(robot);
    }
}
