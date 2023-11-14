package Lab3.src.main.java.command;

import Lab3.src.main.java.command.Command;
import Lab3.src.main.java.snapshot.Snapshot;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CommitCommand implements Command {
  public void execute(String[] args, Snapshot snapshot) {
    // TODO: implement.
    System.out.println("Execute commit");

    snapshot.saveLastSnapshotTime();
    System.out.println("Last snapshot time: " + LocalDateTime.ofInstant(Instant.ofEpochMilli(snapshot.getLastSnapshotTime()), ZoneId.systemDefault()));
    System.out.println("Last snapshot files: " + snapshot.getLastSnapshotFiles());
    System.out.println("Snapshot time updated. Current state is now the baseline for future changes.\n");
  }
}
