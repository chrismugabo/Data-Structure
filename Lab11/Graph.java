import java.util.*;

public class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list array

    // Constructor
    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
        // For undirected graphs, add the reverse edge as well
        // adj[w].add(v);
    }

    // Recursive DFS starting from vertex v
    public void DFSRecursive(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    // Helper method for recursive DFS
    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // Iterative DFS starting from vertex v
    public void DFSIterative(int v) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
                // Push adjacent nodes to stack
                for (int n : adj[node]) {
                    if (!visited[n]) {
                        stack.push(n);
                    }
                }
            }
        }
    }
}
