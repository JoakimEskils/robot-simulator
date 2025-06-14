package com.robot.simulator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void testValidPlacement() {
        Robot robot = new Robot();
        robot.place(0, 0, Direction.NORTH);
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    void testInvalidPlacement() {
        Robot robot = new Robot();
        robot.place(5, 5, Direction.NORTH); // Invalid placement
        assertFalse(robot.isPlaced());
    }

    @Test
    void testMoveWithinBounds() {
        Robot robot = new Robot();
        robot.place(0, 0, Direction.NORTH);
        robot.move();
        assertEquals(0, robot.getX());
        assertEquals(1, robot.getY());
    }

    @Test
    void testMoveOutOfBounds() {
        Robot robot = new Robot();
        robot.place(0, 4, Direction.NORTH);
        robot.move(); // Should not move
        assertEquals(0, robot.getX());
        assertEquals(4, robot.getY());
    }

    @Test
    void testLeftTurn() {
        Robot robot = new Robot();
        robot.place(0, 0, Direction.NORTH);
        robot.left();
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    void testRightTurn() {
        Robot robot = new Robot();
        robot.place(0, 0, Direction.NORTH);
        robot.right();
        assertEquals(Direction.EAST, robot.getDirection());
    }
}
