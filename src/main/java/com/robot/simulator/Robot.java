package com.robot.simulator;

public interface Robot {
    void place(Position position, Direction direction);
    void move();
    void left();
    void right();
    String report();
    int getX();
    int getY();
    Direction getDirection();
}
