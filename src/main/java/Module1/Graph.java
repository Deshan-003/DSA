import java.util.*;

public class Graph {

    private Map<String, List<String>> adjList;

    // Constructor
    public Graph() {
        adjList = new HashMap<>();
    }

    // Add a vertex
    public void addVertex(String vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge
    public void addEdge(String source, String destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());

        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // Remove this line for directed graph
    }

    // Display the graph
    public void displayGraph() {
        for (String vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            System.out.println(adjList.get(vertex));
        }
    }

    // Main method
    public static void main(String[] args) {

        Graph graph = new Graph();

        // Adding vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // Adding edges
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        // Display graph
        graph.displayGraph();
    }
}

