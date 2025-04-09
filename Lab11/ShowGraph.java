 // Driver class to test the Graph and DFS traversal
public class ShowGraph {
    public static void main(String[] args) {
        // Create a graph with 12 vertices (0 to 11)
        Graph g = new Graph(12);

        // Add directed edges based on the lab diagram
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(5, 10);
        g.addEdge(10, 11);

        // Run DFS starting from vertex 0
        System.out.println("Following is the Depth First Traversal");
        g.DFSRecursive(0);  // Expected: 0 1 3 4 6 5 7 8 9 10 11 2

        // Run DFS starting from vertex 7
        System.out.println("\nFollowing is the Depth First Traversal");
        g.DFSRecursive(7);  // Expected: 7 8 9

        // Run DFS starting from vertex 2
        System.out.println("\nFollowing is the Depth First Traversal");
        g.DFSRecursive(2);  // Expected: 2
    }
}
