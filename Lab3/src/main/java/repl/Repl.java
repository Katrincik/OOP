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
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                // Display options
                System.out.println("What do you want to do?");
                System.out.println("commit - For updating the snapshot");
                System.out.println("info <filename> - For printing general info");
                System.out.println("status - For checking files changes");

                // Read user input
                String choiceInput = input.nextLine();
                String[] args = choiceInput.split("\\s+");
                System.out.println();
                System.out.println("You applied for - " + choiceInput);

                // Create and execute command
                CommandFactory factory = new CommandFactory();
                Command command = factory.build(args[0]);
                command.execute(args, snapshot);
                // TODO: get user input.

                // TODO: create the appropriate command via 'CommandFactory'.

                // TODO: Run the command with all the user args.
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.toString());
                // TODO: decide what to do in case an exception occurs.
            }
        }
    }
}
