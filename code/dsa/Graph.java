package com.example.dsa;

import java.util.*;

public class Graph {
    // No. of vertices
    private int V;

    // Adjacency Lists
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS traversal
    // connected graph
    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[size];
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int deleted = queue.poll();
            System.out.print(deleted + " ");
            for (Integer item : adjacencyList.get(deleted)) {
                if (!visited[item]) {
                    visited[item] = true;
                    queue.add(item);
                }
            }
        }
    }

    // connected graph dfs
    public void dfs(int vertex, boolean[] visited) {
        System.out.print(vertex + " ");
        visited[vertex] = true;
        for (Integer adjacent : adjacencyList.get(vertex)) {
            if (!visited[adjacent]) {
                dfs(adjacent, visited);
            }
        }
    }

    // Driver code
    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.BFS(2);
    }
}