package Lab3.src.main.java.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFile extends File {

  public TextFile(String fileName) {
    super(fileName);
  }

  @Override
  public void printInfo() {
    super.printInfo();

    // TODO: print line count, word count and character count.

    getLineWordCharCount();
  }

  public void getLineWordCharCount() {

    BufferedReader reader = null;
    int charCount = 0;
    int wordCount = 0;
    int lineCount = 0;
    try {
      reader = new BufferedReader(new FileReader(filePath));
      // Reading the first line into currentLine
      String currentLine = reader.readLine();
      while (currentLine != null) {
        lineCount++;
        // Getting number of words in currentLine
        String[] words = currentLine.split(" ");
        wordCount = wordCount + words.length;
        for (String word : words) {
          charCount = charCount + word.length();
        }
        //Reading next line into currentLine
        currentLine = reader.readLine();
      }

      System.out.println("Number Of Chars In A File : "+ charCount);
      System.out.println("Number Of Words In A File : "+ wordCount);
      System.out.println("Number Of Lines In A File : "+ lineCount);
      System.out.println();
    }
    catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
