package Lab3.src.main.java.repl;

import Lab3.src.main.java.command.Command;
import Lab3.src.main.java.command.CommandFactory;
import Lab3.src.main.java.snapshot.Snapshot;
import java.util.Scanner;
/**
 * Read Eval Print Loop.
 */
public class Repl {
  public void run(Snapshot snapshot) {
    while (true) {
      try {
        Scanner input = new Scanner(System.in);
        String choiceInput = input.nextLine();
        String[] args = choiceInput.split("\\s+");
        System.out.println("The input is:" + choiceInput);
        CommandFactory factory = new CommandFactory();
        Command command = factory.build(args[0]);
        command.execute(args, snapshot);
        //read input
        //evoluate it
        //print it that did user
        //continue cause it is like a loop
        // TODO: get user input.

        // TODO: create the appropriate command via 'CommandFactory'.

        // TODO: Run the command with all the user args.
      } catch (Exception e) {
        System.out.println(e.toString());
        // TODO: decide what to do in case an exception occurs.
      }
    }
  }
}
