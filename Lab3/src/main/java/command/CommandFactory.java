package Lab3.src.main.java.command;

import java.util.Objects;

public class CommandFactory {
  public Command build(String commandName) {
    // TODO: create the correct Command instance based on the commnand name. If
    // the command name is unsupported, throw the exception.
    if (commandName.equals("commit")) {
      return new CommitCommand();
    } else if (commandName.equals("info")) {
      return new InfoCommand();
    } else if (commandName.equals("status")) {
      return new StatusCommand();
    } else {
      throw new RuntimeException("Unknown command: " + commandName);
    }
  }
}
