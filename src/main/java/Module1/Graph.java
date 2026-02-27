package Module1;
import java.util.*;
public class Graph {
    private Map<String, List<String>> adjacencyList;
    public Graph() {
        adjacencyList = new LinkedHashMap<>();
    }


    public boolean addLocation(String name) {
        if (adjacencyList.containsKey(name)) {
            System.out.println("  [!] Location '" + name + "' already exists in the graph.");
            return false;
        }
        adjacencyList.put(name, new ArrayList<>());
        System.out.println("  [+] Location '" + name + "' added to graph.");
        return true;
    }

    public boolean removeLocation(String name){
        if (!adjacencyList.containsKey(name)){
            System.out.println(("  [!] Location '" + name + "' not found in graph.");
            return false;
        }
        for (String loc : adjacencyList.keySet()){
            adjacencyList.get(loc).remove(name);

        }

        adjacencyList.remove(name);
        System.out.println("  [-] Location '" + name + "' and all its roads removed.");
        return true;
    }
    public boolean addRoad(String from, String to) {
        if (!adjacencyList.containsKey(from)) {
            System.out.println("  [!] Location '" + from + "' not found.");
            return false;
        }
        if (!adjacencyList.containsKey(to)) {
            System.out.println("  [!] Location '" + to + "' not found.");
            return false;
        }
        if (from.equalsIgnoreCase(to)) {
            System.out.println("  [!] Cannot add a road from a location to itself.");
            return false;
        }
        if (adjacencyList.get(from).contains(to)) {
            System.out.println("  [!] Road between '" + from + "' and '" + to + "' already exists.");
            return false;
        }

        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
        System.out.println("  [+] Road added between '" + from + "' and '" + to + "'.");
        return true;
    }
    public boolean removeRoad(String from, String to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            System.out.println("  [!] One or both locations not found.");
            return false;
        }
        boolean removed1 = adjacencyList.get(from).remove(to);
        boolean removed2 = adjacencyList.get(to).remove(from);
        if (removed1 && removed2) {
            System.out.println("  [-] Road between '" + from + "' and '" + to + "' removed.");
            return true;
        } else {
            System.out.println("  [!] Road between '" + from + "' and '" + to + "' does not exist.");
            return false;
        }
    }
    public void displayConnection(){
        if (adjacencyList.isEmpty()){
            System.out.println("  [!] No locations in the graph.");
            return;
        }  System.out.println("\n  === Graph Connections (Adjacency List) ===");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.print("  " + entry.getKey() + " --> ");
            if (entry.getValue().isEmpty()) {
                System.out.print("(no connections)");
            } else{
                System.out.print(String.join(" -> ", entry.getValue()));

            }
            System.out.println();
        }
        System.out.println("  ==========================================");
    }






}
