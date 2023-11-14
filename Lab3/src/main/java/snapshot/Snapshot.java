package Lab3.src.main.java.snapshot;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Snapshot {
    // TODO: add necessary attributes storing the state about all of the files. It
    // could be Map<FileName, FileHash> as well as Snapshot timestamp.
    // save state after commit

    // The timestamp of the last snapshot
    private long lastSnapshotTime;

    // The file path for storing the snapshot timestamp
    private final String fileName = "Lab3/src/main/java/snapshot/snapshot_time.txt";

    public Snapshot() {
        this.lastSnapshotTime = loadLastSnapshotTime();
    }

    // If the file exists and is not empty, it reads the first line as the timestamp.
    // If the file doesn't exist or an error occurs, it sets the current time as the last snapshot time.
    private long loadLastSnapshotTime() {
        Path path = FileSystems.getDefault().getPath(fileName);
        if (Files.exists(path)) {
            try {
                List<String> lines = Files.readAllLines(path);
                if (!lines.isEmpty()) {
                    return Long.parseLong(lines.get(0).trim());
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return System.currentTimeMillis();
    }

    // Saves the current time as the last snapshot time in a file
    public void saveLastSnapshotTime() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(Long.toString(System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getLastSnapshotTime() {
        return lastSnapshotTime;
    }
}
