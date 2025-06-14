package com.robot.simulator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void testInitialState_NotPlaced() {
        RobotImpl robot = new RobotImpl();
        assertFalse(robot.isPlaced());
        robot.move();  // Should do nothing without errors
        robot.left();  // Should do nothing without errors
        robot.right(); // Should do nothing without errors
    }

    @Test
    void testValidPlacement() {
        RobotImpl robot = new RobotImpl();
        robot.place(0, 0, Direction.NORTH);
        assertTrue(robot.isPlaced());
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    void testInvalidPlacement() {
        RobotImpl robot = new RobotImpl();
        robot.place(5, 5, Direction.NORTH); // Out of bounds
        assertFalse(robot.isPlaced());
    }

    @Test
    void testMultiplePlaceCommands() {
        RobotImpl robot = new RobotImpl();
        robot.place(0, 0, Direction.NORTH);
        assertTrue(robot.isPlaced());
        robot.place(2, 2, Direction.EAST);
        assertEquals(2, robot.getX());
        assertEquals(2, robot.getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    void testMoveWithinBounds() {
        RobotImpl robot = new RobotImpl();
        robot.place(1, 1, Direction.NORTH);
        robot.move();
        assertEquals(1, robot.getX());
        assertEquals(2, robot.getY());
    }

    @Test
    void testMoveOutOfBounds_Prevented() {
        RobotImpl robot = new RobotImpl();
        robot.place(0, 4, Direction.NORTH);
        robot.move();  // Should NOT move beyond boundary
        assertEquals(0, robot.getX());
        assertEquals(4, robot.getY());
    }

    @Test
    void testMoveInAllDirections() {
        RobotImpl robot = new RobotImpl();

        robot.place(1, 1, Direction.NORTH);
        robot.move();
        assertEquals(2, robot.getY());

        robot.place(1, 1, Direction.EAST);
        robot.move();
        assertEquals(2, robot.getX());

        robot.place(1, 1, Direction.SOUTH);
        robot.move();
        assertEquals(0, robot.getY());

        robot.place(1, 1, Direction.WEST);
        robot.move();
        assertEquals(0, robot.getX());
    }

    @Test
    void testLeftTurn() {
        RobotImpl robot = new RobotImpl();
        robot.place(0, 0, Direction.NORTH);
        robot.left();
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    void testRightTurn() {
        RobotImpl robot = new RobotImpl();
        robot.place(0, 0, Direction.NORTH);
        robot.right();
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    void testFullRotationLeft() {
        RobotImpl robot = new RobotImpl();
        robot.place(0, 0, Direction.NORTH);

        for (int i = 0; i < 4; i++) {
            robot.left();
        }
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    void testFullRotationRight() {
        RobotImpl robot = new RobotImpl();
        robot.place(0, 0, Direction.NORTH);

        for (int i = 0; i < 4; i++) {
            robot.right();
        }
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    void testReportOutput() {
        RobotImpl robot = new RobotImpl();
        assertEquals("Robot not yet placed", robot.report());

        robot.place(1, 2, Direction.EAST);
        assertEquals("1,2,EAST", robot.report());
    }
}
