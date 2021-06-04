// Implementing a undirected graph using Adjacency List concept.
// Adjacency List contains ArrayList for each vertex( We can also use LinkedList, that we will see in BFS example)
// And the array for each vertex in turn will contain the data to which it is linked
/*
    0--1----2   let's assume that , 0 is connected with 1,4, 1 is connected with 0,4,3,2, 2 is connected with 1,3, 3 is connected with 1,2,4 and 4 is connected with 0,1,3
    |  |    |
    4--3----
    Adjacency List will represent this as
    Array index
    0           -   1   -   4
    1           -   0   -   2   -   3   -   4
    2           -   1   -   3
    3           -   1   -   2   -   4
    4           -   0   -   1   -   3
 */

package DataStructure.Graphs;

import java.util.ArrayList;

public class Graph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for (int i = 0; i < adj.size(); i++){
            System.out.println("Adjacency List of Vertex : "+i);

            for (int j = 0; j < adj.get(i).size(); j++){
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Creating a graph with below mentioned vertices
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);

        for(int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());  // Will create array list at each index from 0 to 4

        addEdge(adj,0,1);
        addEdge(adj,0,4);

        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,1,4);

        addEdge(adj,2,3);

        addEdge(adj,3,4);

        printGraph(adj);


    }

}
