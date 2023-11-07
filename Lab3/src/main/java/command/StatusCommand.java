package Lab3.src.main.java.command;

import Lab3.src.main.java.command.Command;
import Lab3.src.main.java.snapshot.Snapshot;

public class StatusCommand implements Command {
  public void execute(String[] args, Snapshot snapshot) {
    // TODO: implement.
    //what you did (status)
    //difference between last commit and new one (like what that was changed)
    System.out.println("Execute status");

  }
}
