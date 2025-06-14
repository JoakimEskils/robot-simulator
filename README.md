## Project Structure Overview

- **Main** — program entry point.
- **CommandProcessor** — reads commands from file and manages execution.
- **CommandParser** — turns text lines into command objects.
- **CommandExecutor** — runs commands on the robot.
- **Commands** — classes like `PlaceCommand`, `MoveCommand`, etc. Each represents a specific command.
- **Robot & RobotImpl** — robot interface and implementation.
- **Position & Direction** — represent the robot’s location and facing.

---

## Classes at a Glance

| Class             | What it does                          |
|-------------------|-------------------------------------|
| CommandProcessor  | Reads and processes commands file   |
| CommandParser     | Parses command text into objects     |
| CommandExecutor   | Executes commands on the robot       |
| Robot, RobotImpl  | Robot interface and implementation   |
| PlaceCommand      | Command to place the robot            |
| MoveCommand       | Command to move forward               |
| LeftCommand       | Command to turn left                  |
| RightCommand      | Command to turn right                 |
| ReportCommand     | Command to report position            |
| Position          | Holds X, Y coordinates                |
| Direction         | Enum of possible directions           |
