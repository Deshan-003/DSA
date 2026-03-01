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
    private void  printMenu(){
        System.out.println("  |        Route Planner - Main Menu        |");
        System.out.println("  | 1. Add Location                         |");
        System.out.println("  | 2. Remove Location                      |");
        System.out.println("  | 3. Add Road (between two locations)     |");
        System.out.println("  | 4. Remove Road                          |");
        System.out.println("  | 5. Display All Connections              |");
        System.out.println("  | 6. BFS Traversal (uses Queue)          |");
        System.out.println("  | 7. DFS Traversal (uses Stack)          |");
        System.out.println("  | 8. Display BST (all locations sorted)  |");
        System.out.println("  | 0. Back to Main Menu                    |");
    }
private void addLocation(){
        System.out.println("\n  -- Add Location --");
        String name = getStringInput("  enter location name");
        if (name.isEmpty()){
            System.out.println("  [!] Location name cannot be empty.");
            return;
        }
        locationTree.insert(name);
        System.out.println("  [BST] '" + name + "' added to BST.");

        graph.addLocation(name);

}
    private void removeLocation() {
        System.out.println("\n  -- Remove Location --");

        if (graph.isEmpty()) {
            System.out.println("  [!] No locations to remove.");
            return;
        }
        displayAllLocations();
        String name = getStringInput("  Enter location name to remove: ");

        if (!graph.locationExists(name)) {
            System.out.println("  [!] Location '" + name + "' not found.");
            return;
        }

        // Remove from both BST and Graph
        locationTree.delete(name);
        System.out.println("  [BST] '" + name + "' removed from BST.");
        graph.removeLocation(name);
    }
    private void addRoad() {
        System.out.println("\n  -- Add Road --");

        if (graph.isEmpty()) {
            System.out.println("  [!] No locations exist yet. Add locations first.");
            return;
        }

        displayAllLocations();
        String from = getStringInput("  Enter first location: ");
        String to   = getStringInput("  Enter second location: ");

        graph.addRoad(from, to);
    }

private void removeRoad(){
        System.out.println("\n  -- Remove Road --");
    if (graph.isEmpty()) {
        System.out.println("  [!] No locations exist.");
        return;
    }
    displayAllLocations();
    String from = getStringInput("  Enter first location: ");
    String to = getStringInput("  Enter second location: ");
    graph.removeRoad(from, to);
}
    private void displayConnections() {
        graph.displayConnections();
    }

    private void bfsTraversal() {
        if (graph.isEmpty()) {
            System.out.println("  [!] Graph is empty.");
            return;
        }
        displayAllLocations();
        String start = getStringInput("  Enter starting location for BFS: ");
        graph.bfsTraversal(start);
    }
    private void dfsTraversal(){
        if (graph.isEmpty()){
            System.out.println("Grph is empty. ");
            return;
        }
        displayAllLocations();
        String start = getStringInput(" enter starting location for DFS");
            graph.dfsTraversal(start);
    }


    private void displayBST(){
        System.out.println();
        locationTree.displayInOrder();
    }

    private void displayAllLocations() {
        System.out.print("  Current Locations: ");
        System.out.println(graph.getAllLocations());
    }
    private void loadSampleData() {
        System.out.println("\n  [INFO] Loading sample city data...");

        String[] locations = {"CityHall", "Hospital", "School", "Park", "Market", "Airport"};
        for (String loc : locations) {
            locationTree.insert(loc);
            graph.addLocation(loc);
        }

        graph.addRoad("CityHall", "Hospital");
        graph.addRoad("CityHall", "Park");
        graph.addRoad("Hospital", "School");
        graph.addRoad("School", "Market");
        graph.addRoad("Park", "Market");
        graph.addRoad("Market", "Airport");

        System.out.println("  [INFO] Sample data loaded! (6 locations, 6 roads)");
    }



}
