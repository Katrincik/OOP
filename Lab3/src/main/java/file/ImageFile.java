package Lab3.src.main.java.file;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ImageFile extends File {

  private int width;
  private int height;

  public ImageFile(String fileName) {
    super(fileName);
  }
  @Override
  public void printInfo() {
    super.printInfo();

    // TODO: print image size, along with the default info.

    getFileSize();
  }

  protected void getFileSize() {
    try {
      // Convert filePath to a Path and create an InputStream
      try (InputStream is = Files.newInputStream(Paths.get(filePath))) {
        BufferedImage image = ImageIO.read(is);
        this.width = image.getWidth();
        this.height = image.getHeight();
        System.out.println("Image width: " + this.width + " px");
        System.out.println("Image height: " + this.height + " px");
        System.out.println();
      }
    } catch (IOException e) {
      System.err.println("Error retrieving image dimensions: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
