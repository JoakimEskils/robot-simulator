# Robot Simulator

A simple robot simulator that processes text commands to control a robot on a grid. The simulator supports commands like `PLACE`, `MOVE`, `LEFT`, `RIGHT`, and `REPORT`.

---

## Features

- Reads commands from a text file and executes them sequentially.
- Supports placing the robot at specific coordinates with a direction.
- Moves the robot on the grid while handling boundaries.
- Turns the robot left or right.
- Reports the robot’s current position and direction.
- Ignores invalid commands gracefully.

---

## Design Overview

The project is structured following professional software engineering principles:

- **Separation of Concerns**: Parsing commands and executing them are handled by separate components.
- **Command Pattern**: Each command is represented as an immutable object implementing a `Command` interface.
- **Immutability & Value Objects**: Command objects encapsulate all required data and behavior and are immutable.
- **Single Responsibility Principle**: Each class has a clear and focused role.

---

## Benefits of this design

- **Separation of Concerns**  
  Parsing and execution logic are cleanly separated, making the code easier to maintain and extend.

- **Command Pattern**  
  Each command is represented as an immutable object implementing the `Command` interface. This makes it easy to add new commands and extend functionality without modifying existing code.

- **Immutability & Value Objects**  
  Commands like `PlaceCommand` are designed to be immutable value objects, encapsulating command data and behavior together.

- **Single Responsibility**  
  Each class has a clear responsibility:
    - `CommandProcessor` coordinates reading and processing commands.
    - `CommandParser` handles parsing and validation.
    - `CommandExecutor` handles command execution.
    - Command objects encapsulate the actions.

This design follows professional best practices and can easily be scaled or adapted for more complex command processing needs.

---

## Usage

1. Prepare a text file containing commands, one per line. Example:

PLACE,1,2,EAST
MOVE
LEFT
REPORT

yaml
Copy
Edit

2. Run the program and pass the command file as an argument.

---

## Example

$ java -jar robot-simulator.jar commands.txt
Output: 1,3,NORTH

yaml
Copy
Edit

---

## Project Structure

- `CommandProcessor`: Reads command input and manages processing.
- `CommandParser`: Parses command strings into command objects.
- `CommandExecutor`: Executes commands on the robot.
- Command classes (e.g., `PlaceCommand`, `MoveCommand`): Immutable objects implementing the `Command` interface.
- `Robot` interface and its implementation: Defines robot actions and state.

---

## Requirements

- Java 17+ (tested on OpenJDK 24)
- Maven (for building the project)

---

## Building

Use Maven to compile and package the project:

```bash
mvn clean package
Running Tests
The project includes JUnit 5 tests covering commands and robot behavior. Run tests with:

bash
Copy
Edit
mvn test






Class	Responsibility
Command	Interface or abstract base for all commands
CommandExecutor	Executes a given command on the robot
CommandParser	Parses text lines into Command instances
CommandProcessor	Reads command files, uses parser & executor
Direction	Enum for robot directions
InvalidCommand	Represents invalid/unrecognized commands
LeftCommand	Concrete command implementations (Left)
MoveCommand	Concrete command implementations (Move)
PlaceCommand	Concrete command implementations (Place)
ReportCommand	Concrete command implementations (Report)
RightCommand	Concrete command implementations (Right)
Position	Represents robot coordinates
Robot	Robot interface
RobotImpl	Robot implementation
Main	Entry point to the program