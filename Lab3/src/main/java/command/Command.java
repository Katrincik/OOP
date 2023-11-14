package Lab3.src.main.java.command;

import Lab3.src.main.java.snapshot.Snapshot;

/**
 * Command interface. All supported commands should implement it.
 */
public interface Command {
  void execute(String[] args, Snapshot snapshot);
}
