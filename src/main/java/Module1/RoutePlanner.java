package Module1;
import java.util.Scanner;
public class RoutePlanner {
    private Graph graph;
    private BST locationTree;
    private Scanner scanner;


    public RoutePlanner(Scanner scanner){
        this.graph = new Graph();
        this.locationTree = new BST();
        this.scanner=scanner;
    }

    public void run(){
        int choice =-1;

        System.out.println("module 1 smart city route planner ");

//        loadSampleData();

        while(choice !=0){
            printMenu();
            choice = getIntInput("enter your choice");

            switch (choice) {
                case 1:
                    addLocation();
                    break;
                case 2:
                    removeLocation();
                    break;
                case 3:
                    addRoad();
                    break;
                case 4:
                    removeRoad();
                    break;
                case 5:
                    displayConnections();
                    break;
                case 6:
                    bfsTraversal();
                    break;
                case 7:
                    dfsTraversal();
                    break;
                case 8:
                    displayBST();
                    break;
                case 0:
                    System.out.println("\n  Returning to main menu...\n");
                    break;
                default:
                    System.out.println("  [!] Invalid choice. Please try again.");
            }

        }

    }



}
