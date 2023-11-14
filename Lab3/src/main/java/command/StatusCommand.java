package Lab3.src.main.java.command;

import Lab3.src.main.java.command.Command;
import Lab3.src.main.java.snapshot.Snapshot;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;

public class StatusCommand implements Command {
  @Override
  public void execute(String[] args, Snapshot snapshot) {
    // TODO: implement.
    //what you did (status)
    //difference between last commit and new one (like what that was changed)
    System.out.println("Execute status");

    System.out.println("Last Snapshot Time: " + LocalDateTime.now());

    // Flag to track if any files have changed since the last snapshot
    boolean filesChanged = false;
    String folderPath = "Lab3/src/main/java/data/";

    try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath))) {
      for (Path file : stream) {
        if (Files.isRegularFile(file)) {
          // Retrieves the last modified time of the file
          long fileLastModifiedTime = Files.getLastModifiedTime(file).toMillis();
          String relativePath = file.getFileName().toString();
          // Checks if the file was modified after the last snapshot
          if (fileLastModifiedTime > snapshot.getLastSnapshotTime()) {
            System.out.println(relativePath + " - Changed ");
            filesChanged = true;
          } else {
              System.out.println(relativePath + " - No Change");
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (!filesChanged) {
      System.out.println("No files were changed since the last snapshot.\n");
    } else {
      System.out.println("Some files were changed since the last snapshot.\n");
    }
  }
}
