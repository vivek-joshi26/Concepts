/*
A Graph may contain cycles, and may point to the same vertex again, so we should maintain a array to check whether that vertex is already visited or not
 */
package DataStructure.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFS {
    private int V;      // Size of Graph
    private LinkedList<Integer> adj[];      // Adjacency List created to keep track of edges

    GraphBFS(int v){
        V = v;
        adj = new LinkedList[v];            // creates Adjacency List of size of Vertexes
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList();      // Initialises LinkedList at each index of arrat
    }

    public void addEdge(int v, int w){          // Adds the edge for a particular vertex
        adj[v].add(w);
    }


    void BFS(int s){                            // Does the BFS

        boolean[] visited = new boolean[V];     // Array to maintain a record to check if the vertex is already visited

        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.isEmpty() != true){
            s = queue.poll();
            System.out.print(s+" ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if(visited[n] != true){
                    visited[n] = true;
                    queue.add(n);
                }

            }
        }



    }


    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
}
