// Creating Graphs using the Adjacency Matrix concept to represent the links between the vertex
package DataStructure.Graphs;

public class GraphMatrix {
    // Adjacency Matrix created with boolean type
    private boolean adjMatrix[][];
    private int vertexCount;

    GraphMatrix(int vertexCount){
        this.vertexCount = vertexCount;
        adjMatrix = new boolean[vertexCount][vertexCount];

    }

    public void addEdge(int u, int v){
        if(u >= 0 && u < vertexCount && v > 0 && v < vertexCount){
            adjMatrix[u][v] = true;     // In case of undirected graph
            adjMatrix[v][u] = true;
        }
    }

    public void removeEdge(int u, int v){
        if(u >= 0 && u < vertexCount && v > 0 && v < vertexCount){
            adjMatrix[u][v] = false;     // In case of undirected graph
            adjMatrix[v][u] = false;
        }

    }

    public boolean isEdge(int u, int v){
        if(u >= 0 && u < vertexCount && v > 0 && v < vertexCount)
            return adjMatrix[u][v];
        return false;
    }

    public void printEdges(){
        for(int i = 0; i < vertexCount; i++){
            System.out.print("Connection for vertex : "+i+" -> ");
            for (int j = 0; j < vertexCount; j++){
                if(adjMatrix[i][j] == true)
                    System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphMatrix obj1 = new GraphMatrix(5);
        obj1.addEdge(0,1);
        obj1.addEdge(0,4);
        obj1.addEdge(1,2);
        obj1.addEdge(1,3);
        obj1.addEdge(1,4);
        obj1.addEdge(2,3);
        obj1.addEdge(3,4);
        obj1.printEdges();
    }
}
