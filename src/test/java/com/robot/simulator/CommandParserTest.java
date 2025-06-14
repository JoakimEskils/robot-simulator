package com.robot.simulator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {
    private final CommandParser parser = new CommandParser();

    @Test
    void testParsePlaceCommand_valid() {
        Command cmd = parser.parse("PLACE,0,1,EAST");
        assertTrue(cmd instanceof PlaceCommand);
        PlaceCommand placeCmd = (PlaceCommand) cmd;
        Position pos = placeCmd.getPosition();
        assertEquals(0, pos.getX());
        assertEquals(1, pos.getY());
        assertEquals(Direction.EAST, placeCmd.getDirection());
    }

    @Test
    void testParseMoveCommand() {
        Command cmd = parser.parse("MOVE");
        assertTrue(cmd instanceof MoveCommand);
    }

    @Test
    void testParseLeftCommand() {
        Command cmd = parser.parse("LEFT");
        assertTrue(cmd instanceof LeftCommand);
    }

    @Test
    void testParseRightCommand() {
        Command cmd = parser.parse("RIGHT");
        assertTrue(cmd instanceof RightCommand);
    }

    @Test
    void testParseReportCommand() {
        Command cmd = parser.parse("REPORT");
        assertTrue(cmd instanceof ReportCommand);
    }

    @Test
    void testParseInvalidCommand_returnsInvalidCommand() {
        Command cmd = parser.parse("FOOBAR");
        assertTrue(cmd instanceof InvalidCommand);
    }

    @Test
    void testParseEmptyCommand_returnsInvalidCommand() {
        Command cmd = parser.parse("");
        assertTrue(cmd instanceof InvalidCommand);
    }

    @Test
    void testParseMalformedPlaceCommand_returnsInvalidCommand() {
        Command cmd = parser.parse("PLACE,1");
        assertTrue(cmd instanceof InvalidCommand);
    }

    @Test
    void testParsePlaceCommandWithInvalidDirection_returnsInvalidCommand() {
        Command cmd = parser.parse("PLACE,1,2,UP");
        assertTrue(cmd instanceof InvalidCommand);
    }
}
