package Lab3.src.main.java.file;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class File {

    public String fileName;
    public String filePath;

    public File(String fileName) {
      this.fileName = fileName;
      this.filePath = "Lab3/src/main/java/data/" + fileName;
    }

    public void printInfo() {
        System.out.println("File name: " + fileName);
        // Print the file extension
        String extension = getFileExtension();
        System.out.println("File Extension: " + (extension.isEmpty() ? "[No Extension]" : extension.toUpperCase()));
        // Print file attributes
        printFileAttributes();

        // TODO: print file name, pretty print of the file extension, created and
        // updated date and time.
    }

    protected String getFileExtension() {
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            return fileName.substring(index + 1);
        }
        // Return empty string if no extension found
        return "";
    }

    private void printFileAttributes() {
        try {
            Path path = Paths.get(filePath);
            System.out.println("Absolute Path: " + path.toAbsolutePath());
            if (!Files.exists(path)) {
                System.out.println("The file does not exist: " + path);
                return;
            }
            if (!Files.isReadable(path)) {
                System.out.println("The file is not readable: " + path);
                return;
            }
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
            System.out.println("Created Date & Time: " + formatter.format(attrs.creationTime().toInstant()));
            System.out.println("Last Modified Date & Time: " + formatter.format(attrs.lastModifiedTime().toInstant()));
        } catch (IOException e) {
            System.err.println("Error retrieving file attributes: " + e.getMessage());
            e.printStackTrace(); // This will print the full stack trace
        }
    }
}
