package com.robot.simulator;

public interface Robot {
    void place(int x, int y, Direction direction);
    void move();
    void left();
    void right();
    String report();
}