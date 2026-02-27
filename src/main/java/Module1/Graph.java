package Module1;// Graph.java
// Member 1 - Graph implementation using Adjacency List

import java.util.*;

class Graph {

    private Map<String, List<String>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    // Add location
    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
        System.out.println("Location added successfully.");
    }

    // Remove location
    public void removeLocation(String location) {
        adjList.remove(location);

        for (List<String> neighbors : adjList.values()) {
            neighbors.remove(location);
        }

        System.out.println("Location removed successfully.");
    }

    // Add road (undirected)
    public void addRoad(String loc1, String loc2) {
        if (!adjList.containsKey(loc1) || !adjList.containsKey(loc2)) {
            System.out.println("One or both locations do not exist.");
            return;
        }

        adjList.get(loc1).add(loc2);
        adjList.get(loc2).add(loc1);

        System.out.println("Road added successfully.");
    }

    // Remove road
    public void removeRoad(String loc1, String loc2) {
        if (adjList.containsKey(loc1))
            adjList.get(loc1).remove(loc2);

        if (adjList.containsKey(loc2))
            adjList.get(loc2).remove(loc1);

        System.out.println("Road removed successfully.");
    }

    // Display connections
    public void displayGraph() {
        for (String location : adjList.keySet()) {
            System.out.print(location + " -> ");
            System.out.println(adjList.get(location));
        }
    }

    // BFS Traversal using Queue
    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.println("BFS Traversal:");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }
}
