package Module1;
import java.util.Scanner;

public class GraphModuleMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("");
        System.out.println("  CCS2300 - Data Structures & Algorithms         ");
        System.out.println("    Assignment 1 - Group Project                 ");
        System.out.println("==================================================");

        while (choice != 0) {
            System.out.println("\n  ======= MAIN MENU =======");
            System.out.println("  1. Module 1 - Smart City Route Planner");
            System.out.println("  2. Module 2 - Data Sorter (Sorting Algorithms)");
            System.out.println("  3. Module 3 - Algorithm Performance Analyzer");
            System.out.println("  0. Exit");
            System.out.print("  Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    RoutePlanner module1 = new RoutePlanner(scanner);
                    module1.run();
                    break;
                case 2:
                    // Member 2's module goes here
                    System.out.println("  [Module 2 - To be implemented by Member 2]");
                    break;
                case 3:
                    // Member 3's module goes here
                    System.out.println("  [Module 3 - To be implemented by Member 3]");
                    break;
                case 0:
                    System.out.println("\n  Thank you! Goodbye.");
                    break;
                default:
                    System.out.println("  Invalid choice.");
            }
        }

        scanner.close();
    }
}
