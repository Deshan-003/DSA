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


}
