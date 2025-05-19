# Tennis Score Kata

This project implements a simple tennis score calculator in Java, following the Tennis scoring rules.

## Description

- Takes as input a sequence of characters (`A` or `B`), each representing the player who won the ball.
- Prints the score after each point.
- Handles all tennis scoring rules including points, deuce, advantage, and game win.
- Implemented with Java 21, Maven, and tested with JUnit 5.
- Uses TDD approach for development.

## How to run

### Running with input as a command line argument

```bash
mvn compile -q exec:java -Dexec.args="ABABAA"
```

### Running with user input
```bash
mvn compile -q exec:java
```