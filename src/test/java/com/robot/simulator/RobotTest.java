package com.robot.simulator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotTest {

    private Robot robot;

    @BeforeEach
    void setUp() {
        robot = new RobotImpl();  // Assuming RobotImpl is your Robot implementation class
    }

    @Test
    void testPlaceValidPosition() {
        Position position = new Position(1, 2);
        Direction direction = Direction.EAST;
        robot.place(position, direction);

        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    void testMoveForward() {
        robot.place(new Position(0, 0), Direction.NORTH);
        robot.move();
        assertEquals(0, robot.getX());
        assertEquals(1, robot.getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    void testLeftTurn() {
        robot.place(new Position(0, 0), Direction.NORTH);
        robot.left();
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    void testRightTurn() {
        robot.place(new Position(0, 0), Direction.NORTH);
        robot.right();
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    void testReport() {
        robot.place(new Position(2, 3), Direction.SOUTH);
        String report = robot.report();
        assertEquals("2,3,SOUTH", report);
    }

    @Test
    void testIgnoreInvalidPlace() {
        // Assuming the robot ignores place commands out of bounds or invalid
        robot.place(new Position(-1, -1), Direction.NORTH);
        assertNull(robot.getDirection(), "Robot direction should be null after invalid place");
    }

}