package Module1;

import java.util.*;

public class Graph {

    // Adjacency list: each location maps to its list of connected locations
    private final Map<String, List<String>> adjacencyList;


    public Graph() {
        adjacencyList = new LinkedHashMap<>();
    }


    public void addLocation(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("  [!] Location name cannot be empty.");
            return;
        }
        if (adjacencyList.containsKey(name)) {
            System.out.println("  [!] Location '" + name + "' already exists.");
            return;
        }
        adjacencyList.put(name, new ArrayList<>());
        System.out.println("  [+] Location '" + name + "' added to graph.");
    }


    public void removeLocation(String name) {
        if (!adjacencyList.containsKey(name)) {
            System.out.println("  [!] Location '" + name + "' not found.");
            return;
        }
        for (String loc : adjacencyList.keySet()) {
            adjacencyList.get(loc).remove(name);
        }
        adjacencyList.remove(name);
        System.out.println("  [-] Location '" + name + "' and all its roads removed.");
    }

    // -------------------------------------------------------
    // ADD ROAD (undirected edge between two locations)
    // -------------------------------------------------------
    public void addRoad(String from, String to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            System.out.println("  [!] One or both locations not found.");
            return;
        }
        if (from.equalsIgnoreCase(to)) {
            System.out.println("  [!] Cannot connect a location to itself.");
            return;
        }
        if (adjacencyList.get(from).contains(to)) {
            System.out.println("  [!] Road already exists between '" + from + "' and '" + to + "'.");
            return;
        }
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
        System.out.println("  [+] Road added: " + from + " <--> " + to);
    }

    // -------------------------------------------------------
    // REMOVE ROAD (undirected edge)
    // -------------------------------------------------------
    public void removeRoad(String from, String to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            System.out.println("  [!] One or both locations not found.");
            return;
        }
        boolean r1 = adjacencyList.get(from).remove(to);
        boolean r2 = adjacencyList.get(to).remove(from);

        if (r1 && r2) {
            System.out.println("  [-] Road removed: " + from + " <--> " + to);
        } else {
            System.out.println("  [!] No road exists between '" + from + "' and '" + to + "'.");
        }
    }

    // -------------------------------------------------------
    // DISPLAY ALL CONNECTIONS (adjacency list view)
    // -------------------------------------------------------
    public void displayConnections() {
        if (adjacencyList.isEmpty()) {
            System.out.println("  [!] Graph is empty. No locations added yet.");
            return;
        }
        System.out.println("\n ===========================================");
        System.out.println("       City Map - Adjacency List View         ");
        System.out.println("==============================================");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            String connections = entry.getValue().isEmpty()
                    ? "(no roads)"
                    : String.join(" --> ", entry.getValue());
            System.out.printf("  ║  %-15s : %s%n", entry.getKey(), connections);
        }
        System.out.println("============================================");
    }

    // -------------------------------------------------------
    // BFS TRAVERSAL
    // -------------------------------------------------------
    public void bfsTraversal(String start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("  [!] Starting location not found.");
            return;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.print("  BFS: ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            for (String neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }


    public void dfsTraversal(String start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("  [!] Starting location not found.");
            return;
        }
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);

        System.out.print("  DFS: ");
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + " ");
                for (String neighbor : adjacencyList.get(current)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }


    public boolean locationExists(String name) {
        return adjacencyList.containsKey(name);
    }

    public List<String> getNeighbors(String name) {
        return adjacencyList.getOrDefault(name, new ArrayList<>());
    }

    public Set<String> getAllLocations() {
        return adjacencyList.keySet();
    }

    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }

    public int roadCount() {
        int total = 0;
        for (List<String> neighbors : adjacencyList.values()) {
            total += neighbors.size();
        }
        return total / 2; // undirected, divide by 2
    }
}