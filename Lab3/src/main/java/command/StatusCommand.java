package Lab3.src.main.java.command;

import Lab3.src.main.java.command.Command;
import Lab3.src.main.java.snapshot.Snapshot;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class StatusCommand implements Command {
  @Override
  public void execute(String[] args, Snapshot snapshot) {
    // TODO: implement.
    //what you did (status)
    //difference between last commit and new one (like what that was changed)
    System.out.println("Execute status");

    System.out.println("Last Snapshot Time: " + LocalDateTime.now());

    Set<String> currentFiles = new HashSet<>();
    Set<String> lastSnapshotFiles = new HashSet<>(snapshot.getLastSnapshotFiles());

    String folderPath = "Lab3/src/main/java/data/";

    try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath))) {
      for (Path file : stream) {
        if (Files.isRegularFile(file)) {
          String relativePath = file.getFileName().toString();
          currentFiles.add(relativePath);

          // Check for new files
          if (!lastSnapshotFiles.contains(relativePath)) {
            System.out.println(relativePath + " - New File");
            continue;
          }

          // Check for changed files
          long fileLastModifiedTime = Files.getLastModifiedTime(file).toMillis();
          if (fileLastModifiedTime > snapshot.getLastSnapshotTime()) {
            System.out.println(relativePath + " - Changed");
          } else {
            System.out.println(relativePath + " - No Change");
          }

          // Remove checked file from the set
          lastSnapshotFiles.remove(relativePath);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Detect deleted files
    for (String file : lastSnapshotFiles) {
      System.out.println(file + " - Deleted");
    }

    // Update the snapshot with the current state of files
    snapshot.setLastSnapshotFiles(currentFiles);
  }
}
