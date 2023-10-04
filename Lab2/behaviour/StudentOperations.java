package Lab2.behaviour;

import java.util.Scanner;

public class StudentOperations {

    private void studentInfo(String changeInput) {

    }
    static void changeFirstName (String Change_Input) {

    }

    private void changeLastName(String Change_Input) {

    }

    public void studentOperations() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Students Operations:
                    What do you want to do?
                    si/<email> - display (s)tudent (i)nfo
                    cfn/<new first name>/ - (c)hange (f)irst (n)ame
                    cln/<new last name>/ - (c)hange (l)ast (n)ame
                    b - Back""");

            System.out.print("your input> ");
            String Change_Input = scanner.nextLine().trim();

            if (Change_Input.startsWith("si/")) {
                studentInfo(Change_Input);
            } else if (Change_Input.startsWith("cfn/")) {
                changeFirstName(Change_Input);
            } else if (Change_Input.startsWith("cln/")) {
                changeLastName(Change_Input);
            } else if (Change_Input.equals("b")) {
                return;
            } else if (Change_Input.equals("q")) {
                System.exit(0);
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
