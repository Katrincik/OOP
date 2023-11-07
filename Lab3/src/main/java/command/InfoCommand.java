package Lab3.src.main.java.command;

import Lab3.src.main.java.command.Command;
import Lab3.src.main.java.file.ImageFile;
import Lab3.src.main.java.file.ProgramFile;
import Lab3.src.main.java.file.TextFile;
import Lab3.src.main.java.snapshot.Snapshot;
import Lab3.src.main.java.file.File;


public class InfoCommand implements Command {
  public void execute(String[] args, Snapshot snapshot) {
    // TODO: implement.
    System.out.println("Execute info");
    String filename = args[1];
    System.out.println(filename);

    if (filename.endsWith(".png") || filename.endsWith(".jpg")) {
      ImageFile file = new ImageFile(filename);
      file.printInfo();
    } else if (filename.endsWith(".txt")) {
      TextFile file = new TextFile(filename);
      file.printInfo();
    } else if (filename.endsWith(".py") || filename.endsWith(".java")) {
      ProgramFile file = new ProgramFile(filename);
      file.printInfo();
    } else {
      File file = new File(filename);
      file.printInfo();
    }
  }
}
