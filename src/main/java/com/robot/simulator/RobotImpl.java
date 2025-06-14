package com.robot.simulator;

public class RobotImpl implements Robot {
    private int x;
    private int y;
    private Direction direction;
    private boolean isPlaced = false;

    private static final int TABLE_WIDTH = 5;
    private static final int TABLE_HEIGHT = 5;

    @Override
    public void place(Position position, Direction direction) {
        if (position == null || direction == null) {
            return;  // optionally ignore null input
        }

        int x = position.getX();
        int y = position.getY();

        if (isValidPosition(x, y)) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.isPlaced = true;
        }
    }

    @Override
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

    @Override
    public void left() {
        if (!isPlaced) return;
        direction = direction.left();
    }

    @Override
    public void right() {
        if (!isPlaced) return;
        direction = direction.right();
    }

    @Override
    public String report() {
        if (!isPlaced) return "Robot not yet placed";
        return x + "," + y + "," + direction;
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < TABLE_WIDTH && y >= 0 && y < TABLE_HEIGHT;
    }

    // Getters if needed
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
