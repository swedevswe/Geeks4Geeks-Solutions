import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class DijkstraAlgorithm {

    static class Edge {
        int targetNode;
        int distance;

        public Edge(int targetNode, int distance) {
            this.targetNode = targetNode;
            this.distance = distance;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(int V, ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[V]; // Distance of every vertex from src
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances as infinity
        dist[src] = 0; // Distance of src from itself is always 0

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0)); // Add source node to the priority queue

        while (!pq.isEmpty()) {
            Node node = pq.poll(); // Remove the node with the smallest distance

            int vertex = node.vertex;
            int distance = node.distance;

            // Visit all the neighbors of the current node
            for (Edge edge : graph[vertex]) {
                int newDist = distance + edge.distance;
                if (newDist < dist[edge.targetNode]) {
                    dist[edge.targetNode] = newDist;
                    pq.add(new Node(edge.targetNode, newDist));
                }
            }
        }

        return dist; // Return the completed distance array
    }

    public static void main(String[] args) {
        // Example usage
        int V = 5; // Number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges
        graph[0].add(new Edge(1, 9));
        graph[0].add(new Edge(2, 6));
        graph[0].add(new Edge(3, 5));
        graph[0].add(new Edge(4, 3));

        graph[2].add(new Edge(1, 2));
        graph[2].add(new Edge(3, 4));

        // Assuming vertices are numbered from 0 to V-1
        int[] dist = dijkstra(V, graph, 0); // 0 is the source vertex

        System.out.println("The shortest path from node 0:");
        for (int i = 0; i < V; i++) {
            System.out.println("to " + i + " is " + dist[i]);
        }
    }
}
