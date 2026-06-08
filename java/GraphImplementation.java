import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Array of lists

    // Constructor to initialize the graph
    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        
        // Initialize every slot in the array with an empty list
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph (Undirected by default)
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Because the graph is undirected
    }

    // Display the adjacency list representation of the graph
    public void display() {
        System.out.println("--- Graph Adjacency List ---");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : adjacencyList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    // Breadth-First Search (BFS) - Uses a Queue
    public void breadthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Traversal starting from " + startVertex + ": ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // Get all adjacent vertices of the current vertex
            for (int neighbor : adjacencyList[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (DFS) - Uses a Stack (or Recursion)
    public void depthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        System.out.print("DFS Traversal starting from " + startVertex + ": ");

        while (!stack.isEmpty()) {
            int current = stack.pop();

            // Check if it's already visited (handles elements added multiple times)
            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;
            }

            // Look at neighbors. (We traverse backwards to match recursive ordering)
            for (int i = adjacencyList[current].size() - 1; i >= 0; i--) {
                int neighbor = adjacencyList[current].get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }
}

// Main class to build the graph and run algorithms
public class GraphImplementation {
    public static void main(String[] args) {
        // Create a graph with 5 vertices (labeled 0, 1, 2, 3, 4)
        Graph graph = new Graph(5);

        /* Constructing the following graph:
              0 --- 1
              |   / |
              |  /  |
              4 --- 2 --- 3
        */
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        // Display the connections
        graph.display();

        // Run Traversals
        graph.breadthFirstSearch(0);
        graph.depthFirstSearch(0);
    }
}