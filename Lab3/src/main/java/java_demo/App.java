/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Lab3.src.main.java.java_demo;

import Lab3.src.main.java.refresher.RefresherJob;
import Lab3.src.main.java.repl.Repl;
import Lab3.src.main.java.snapshot.Snapshot;

public class App {
  public static void main(String[] args) {
    var snapshot = new Snapshot();
    new RefresherJob().run(snapshot);
    new Repl().run(snapshot);
  }
}