package com.robot.simulator.command;

import com.robot.simulator.model.Direction;
import com.robot.simulator.model.Position;
import com.robot.simulator.model.Robot;

public final class PlaceCommand implements Command {
    private final Position position;
    private final Direction direction;

    public PlaceCommand(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void execute(Robot robot) {
        robot.place(position, direction);
    }
}

