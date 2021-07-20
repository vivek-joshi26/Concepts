package DataStructure.Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphsExample {

    private int vertexCount;
    private LinkedList<Integer> adjList[];

    public GraphsExample(int vertexCount) {
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w){
        adjList[v].add(w);
    }

    public void printEdges(){

        for(int i = 0; i < vertexCount; i++){
            System.out.print("Connections or edges from vertex "+i+" -> ");
            Iterator<Integer> iterator = adjList[i].listIterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
        }
    }

    //DFS for connected vertexes, for disconnected just use a for loop to iterate DFSUtil for 0 < vertexcount and inside check visited array also
    public void DFS(int v){
        boolean[] visited = new boolean[vertexCount];
        DFSUtil(v,visited);
    }

    public void DFSUtil(int v,boolean[] visited){
        System.out.print(v+" ");
        visited[v] = true;
        Iterator<Integer> iterator = adjList[v].listIterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            if(visited[n] != true){
                DFSUtil(n,visited);
            }
        }
    }

    //Implementing using stack
    public void DFS2(int v){
        boolean[] visited = new boolean[vertexCount];
        DFSUtil2(v,visited);
    }

    public void DFSUtil2(int v, boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (stack.isEmpty() != true){
            int n = stack.pop();
            if (visited[n] != true)
                System.out.print(n+" ");
            visited[n] = true;
            Iterator<Integer> iterator = adjList[n].listIterator();
            while (iterator.hasNext()){
                int a = iterator.next();
                if(visited[a] != true)
                    stack.push(a);
            }
        }
    }


    // Implementing BFS using Queue
    public void BFS(int v){
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (queue.isEmpty() != true){
            int n = queue.poll();
            System.out.print(n+" ");
            visited[v] = true;
            Iterator<Integer> iterator = adjList[n].listIterator();
            while (iterator.hasNext()){
                int next = iterator.next();
                if(visited[next] != true)
                    queue.add(next);
            }
        }
    }

    public static void main(String[] args) {
        GraphsExample example = new GraphsExample(7);
        example.addEdge(1,2);
        example.addEdge(1,4);
        example.addEdge(2,3);
        example.addEdge(3,1);
        example.addEdge(3,5);
        example.addEdge(4,6);
        example.printEdges();
        System.out.println("Printing DFS using recursive method: ");
        example.DFS(1);
        System.out.println();
        System.out.println("Printing DFS using Stack : ");
        example.DFS2(1);
        System.out.println();
        System.out.println("Printing BFS using Queue : ");
        example.BFS(1);
    }
}
