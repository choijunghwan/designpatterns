package org.example.command.undo;

public interface Command {
    void execute();

    void undo();
}
