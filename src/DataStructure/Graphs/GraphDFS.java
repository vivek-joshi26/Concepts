package DataStructure.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFS {
    private int V;                              // Number of Vertexes
    private LinkedList<Integer> adjList[];        // Adjacency List to maintain the edges

    GraphDFS(int v){
        V = v;
        adjList = new LinkedList[v];
        for(int i = 0; i < v; i++){             // Will initialize a LinkedList at each Index of Adjacency List
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w){
        adjList[v].add(w);                      // add w to v's list, example if edge is present from 0 to 1 then 1 will be added to 0's list
    }

    public void printGraph(){
     for (int v =0; v < V;v++){
            Iterator<Integer> i = adjList[v].listIterator();
            System.out.println("Edges going from "+v+" : ");
            while (i.hasNext()){
                System.out.print(i.next()+" ");
            }
            System.out.println();
        }
    }


    void DFS(int v){
        boolean visited[] = new boolean[V];
        DFSUtil(v,visited);
    }

    void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+" ");
        // Recur all the vertecis adjacent to v
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext()){
            int n = i.next();
            if(visited[n] != true)
                DFSUtil(n,visited);
        }
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.printGraph();
        System.out.println();
        g.DFS(2);
    }
}
