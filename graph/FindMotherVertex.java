package graph;

public class FindMotherVertex {

    public static int getMotherVertex(Graph g){
        if(g.vertices < 1){
            return -1;
        }

        boolean[] visited = new boolean[g.vertices];
        int lastVisited = 0;
        for(int i = 0; i < g.vertices; i++){
            if(!visited[i]){
                dfs(g, i, visited);
                lastVisited = i;
            }
        }

        boolean[] check = new boolean[g.vertices];
        dfs(g, lastVisited, check);

        for(int i = 0; i < g.vertices; i++){
            if(!check[i]){
                return -1;
            }
        }

        return lastVisited;
    }

    public static void dfs(Graph g, int source, boolean[] visited){

        visited[source] = true;
        DoublyLinkedList<Integer>.Node temp = null;
        if(g.adjacencyList[source] != null){
            temp = g.adjacencyList[source].headNode;
        }

        while(temp != null){
            if(visited[temp.data]){
                temp = temp.nextNode;
            } else {
                visited[temp.data] = true;
                dfs(g, temp.data, visited);
                temp = temp.nextNode;
            }
        }
    }
    public static void main(String args[]) {
        
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + getMotherVertex(g));
        
    }
}