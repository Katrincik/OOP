package Lab3.src.main.java.snapshot;

import java.io.*;
import java.nio.file.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Snapshot {
    // TODO: add necessary attributes storing the state about all of the files. It
    // could be Map<FileName, FileHash> as well as Snapshot timestamp.
    // save state after commit

    // The timestamp of the last snapshot
    private long lastSnapshotTime;

    private Set<String> lastSnapshotFiles;

    // The file path for storing the snapshot files
    private final String filesFileName = "Lab3/src/main/java/snapshot/snapshot_files.txt";

    // The file path for storing the snapshot timestamp
    private final String timeFileName = "Lab3/src/main/java/snapshot/snapshot_time.txt";

    public Snapshot() {
        this.lastSnapshotTime = loadLastSnapshotTime();
        this.lastSnapshotFiles = loadLastSnapshotFiles();
    }

    // If the file exists and is not empty, it reads the first line as the timestamp.
    // If the file doesn't exist or an error occurs, it sets the current time as the last snapshot time.
    private long loadLastSnapshotTime() {
        Path path = FileSystems.getDefault().getPath(timeFileName);
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

    private Set<String> loadLastSnapshotFiles() {
        Path path = FileSystems.getDefault().getPath(filesFileName);
        Set<String> files = new HashSet<>();
        if (Files.exists(path)) {
            try {
                List<String> lines = Files.readAllLines(path);
                files.addAll(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return files;
    }

    // Saves the current time as the last snapshot time in a file
    public void saveLastSnapshotTime() {
        try (BufferedWriter timeWriter = new BufferedWriter(new FileWriter(timeFileName));
             BufferedWriter filesWriter = new BufferedWriter(new FileWriter(filesFileName))) {
            timeWriter.write(Long.toString(System.currentTimeMillis()));
            for (String file : lastSnapshotFiles) {
                filesWriter.write(file);
                filesWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateLastSnapshotTime() {
        this.lastSnapshotTime = loadLastSnapshotTime();
    }

    public long getLastSnapshotTime() {
        return lastSnapshotTime;
    }

    public Set<String> getLastSnapshotFiles() {
        return lastSnapshotFiles;
    }

    public void setLastSnapshotFiles(Set<String> files) {
        this.lastSnapshotFiles = files;
    }
}
