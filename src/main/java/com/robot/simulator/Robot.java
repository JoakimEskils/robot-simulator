package com.robot.simulator;

public class Robot {
    private int x;
    private int y;
    private Direction direction;
    private boolean isPlaced = false;

    private static final int TABLE_WIDTH = 5;
    private static final int TABLE_HEIGHT = 5;

    public void place(int x, int y, Direction direction) {
        if (isValidPosition(x, y)) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.isPlaced = true;
        }
    }

    public void move() {
        if (!isPlaced) return;

        switch (direction) {
            case NORTH:
                if (isValidPosition(x, y + 1)) y++;
                break;
            case SOUTH:
                if (isValidPosition(x, y - 1)) y--;
                break;
            case EAST:
                if (isValidPosition(x + 1, y)) x++;
                break;
            case WEST:
                if (isValidPosition(x - 1, y)) x--;
                break;
        }
    }

    public void left() {
        if (!isPlaced) return;

        switch (direction) {
            case NORTH: direction = Direction.WEST; break;
            case WEST:  direction = Direction.SOUTH; break;
            case SOUTH: direction = Direction.EAST; break;
            case EAST:  direction = Direction.NORTH; break;
        }
    }

    public void right() {
        if (!isPlaced) return;

        switch (direction) {
            case NORTH: direction = Direction.EAST; break;
            case EAST:  direction = Direction.SOUTH; break;
            case SOUTH: direction = Direction.WEST; break;
            case WEST:  direction = Direction.NORTH; break;
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < TABLE_WIDTH && y >= 0 && y < TABLE_HEIGHT;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isPlaced() {
        return isPlaced;
    }
}
