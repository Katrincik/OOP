package Lab3.src.main.java.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramFile extends TextFile {

  private int nrOfLines;
  private int nrOfClasses;
  private int nrOfMethods;

  public ProgramFile(String fileName) {
    super(fileName);
  }
  @Override
  public void printInfo() {
    super.printInfo();

    // TODO: print line count, class count, method count (files from previous
    // laboratory can be used).

    getLineClassMethodCount();
  }

  public void getLineClassMethodCount() {
    try {
      // Read all lines from the file
      List<String> lines = Files.readAllLines(Paths.get(filePath));

      Pattern classPattern = Pattern.compile("\\s*class\\s+");
      Pattern methodPattern = Pattern.compile("\\s*(public|private|protected)\\s+(static\\s+)?[\\w\\<\\>\\[\\]]+\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*\\(");

      int numberOfClasses = 0;
      int numberOfMethods = 0;

      for (String line : lines) {
        // Class review
        if (classPattern.matcher(line).find()) {
          numberOfClasses++;
        }
        // Method review
        if (methodPattern.matcher(line).find() || line.contains("def")) {
          numberOfMethods++;
        }
      }

      this.nrOfLines = lines.size();
      this.nrOfClasses = numberOfClasses;
      this.nrOfMethods = numberOfMethods;

    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }

    System.out.println("Number of lines: " + this.nrOfLines);
    System.out.println("Number of classes: " + this.nrOfClasses);
    System.out.println("Number of methods: " + this.nrOfMethods);
    System.out.println();
  }
}
