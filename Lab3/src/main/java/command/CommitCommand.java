package Lab3.src.main.java.command;

import Lab3.src.main.java.command.Command;
import Lab3.src.main.java.snapshot.Snapshot;

public class CommitCommand implements Command {
  public void execute(String[] args, Snapshot snapshot) {
    // TODO: implement.
    System.out.println("Execute commit");

    snapshot.saveLastSnapshotTime();
    System.out.println("Snapshot time updated. Current state is now the baseline for future changes.\n");
  }
}
